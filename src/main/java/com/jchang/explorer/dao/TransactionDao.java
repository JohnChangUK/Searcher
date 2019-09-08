package com.jchang.explorer.dao;

import com.jchang.explorer.db.tables.TransactionTable;
import com.jchang.explorer.dto.AccountDto;
import com.jchang.explorer.dto.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jchang.explorer.db.tables.AccountTable.ACCOUNT_TABLE;
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
                        transaction.getTo(), transaction. getValue(),
                        transaction.getTimestamp(), transaction.getNonce(),
                        transaction.getTransactionIndex(), transaction.getData(),
                        transaction.getType(), transaction.getGasPrice(),
                        transaction.getGasLimit(), transaction.getGasUsed())
                        .onDuplicateKeyIgnore()
                        .execute());
    }
}
