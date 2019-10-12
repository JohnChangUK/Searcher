package com.jchang.explorer.dao;

import com.jchang.explorer.dto.BlockTransactionCount;
import com.jchang.explorer.dto.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.jchang.explorer.db.tables.TransactionTable.TRANSACTION_TABLE;

@Slf4j
@Component
public class TransactionDao {

    private final DSLContext sql;

    public TransactionDao(DSLContext sql) {
        this.sql = sql;
    }

    public void insert(List<TransactionDto> transactions) {
        transactions.forEach(transaction ->
                sql.insertInto(TRANSACTION_TABLE)
                        .values(transaction.getHash(), transaction.getBlockHash(),
                                transaction.getBlockNumber(), transaction.getFrom(),
                                transaction.getTo(), transaction.getValue(),
                                transaction.getTimestamp(), transaction.getNonce(),
                                transaction.getTransactionIndex(), transaction.getData(),
                                transaction.getType(), transaction.getGasPrice(),
                                transaction.getGasLimit(), transaction.getGasUsed())
                        .onDuplicateKeyIgnore()
                        .execute());
    }

    public List<BlockTransactionCount> countTxInBlocks(List<Long> blockNumbers) {
        List<BlockTransactionCount> blockTransactionCounts = new ArrayList<>();
        for (var blockNumber : blockNumbers) {
            Result<Record> fetch = sql.select(TRANSACTION_TABLE.BLOCK_NUMBER)
                    .select(DSL.count().as("count"))
                    .from(TRANSACTION_TABLE)
                    .where(TRANSACTION_TABLE.BLOCK_NUMBER.eq(blockNumber))
                    .groupBy(TRANSACTION_TABLE.BLOCK_NUMBER)
                    .fetch();

            fetch.forEach(result ->
                    blockTransactionCounts.add(BlockTransactionCount.builder()
                            .block(result.get(TRANSACTION_TABLE.BLOCK_NUMBER))
                            .count((Long) result.get("count"))
                            .build()));
        }
        return blockTransactionCounts;
    }
}
