package com.jchang.explorer.dao;

import com.jchang.explorer.dto.BlockDto;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static com.jchang.explorer.db.tables.BlockTable.BLOCK_TABLE;
import static org.jooq.impl.DSL.max;
import static org.jooq.impl.DSL.orderBy;

@Slf4j
@Component
public class BlockDao {

    private final DSLContext sql;

    public BlockDao(DSLContext sql) {
        this.sql = sql;
    }

    public Long getLatestBlockNumber() {
        Result<Record1<Long>> results =
                sql.select(max(BLOCK_TABLE.NUMBER))
                        .from(BLOCK_TABLE)
                        .fetch();

        return results.stream()
                .map(x -> x.getValue(max(BLOCK_TABLE.NUMBER)))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Database not in sync with Ethereum Node"));
    }

    public void insert(BlockDto block) {
        sql.insertInto(BLOCK_TABLE, BLOCK_TABLE.NUMBER, BLOCK_TABLE.HASH, BLOCK_TABLE.TIMESTAMP,
                BLOCK_TABLE.MINER, BLOCK_TABLE.DIFFICULTY, BLOCK_TABLE.TOTAL_DIFFICULTY,
                BLOCK_TABLE.SIZE, BLOCK_TABLE.GAS_USED, BLOCK_TABLE.GAS_LIMIT,
                BLOCK_TABLE.NONCE, BLOCK_TABLE.EXTRA_DATA, BLOCK_TABLE.PARENT_HASH,
                BLOCK_TABLE.UNCLE_HASH, BLOCK_TABLE.STATE_ROOT,
                BLOCK_TABLE.RECEIPTS_ROOT, BLOCK_TABLE.TRANSACTIONS_ROOT)
                .values(block.getNumber(), block.getHash(),
                        block.getTimestamp(), block.getMiner(),
                        block.getDifficulty(), block.getTotalDifficulty(),
                        block.getSize(), block.getGasUsed(),
                        block.getGasLimit(), block.getNonce(),
                        block.getExtraData(), block.getParentHash(),
                        block.getUncleHash(), block.getStateRoot(),
                        block.getReceiptsRoot(), block.getTransactionsRoot())
                .execute();
    }

    public List<BlockDto> sortBlocksByLatest(long startNumber, long endNumber) {
        SelectQuery<Record> query = sql.selectQuery();
        query.addSelect(DSL.asterisk());
        query.addFrom(BLOCK_TABLE);
        query.addConditions(BLOCK_TABLE.NUMBER.between(startNumber, endNumber));
        query.addOrderBy(BLOCK_TABLE.NUMBER.desc());
        Result<Record> result = query.fetch();

        return result.stream()
                .map(record -> BlockDto.builder()
                        .number(record.get(BLOCK_TABLE.NUMBER))
                        .hash(record.get(BLOCK_TABLE.HASH))
                        .timestamp(record.get(BLOCK_TABLE.TIMESTAMP))
                        .miner(record.get(BLOCK_TABLE.MINER))
                        .difficulty(record.get(BLOCK_TABLE.DIFFICULTY))
                        .totalDifficulty(record.get(BLOCK_TABLE.TOTAL_DIFFICULTY))
                        .size(record.get(BLOCK_TABLE.SIZE))
                        .gasUsed(record.get(BLOCK_TABLE.GAS_USED))
                        .gasLimit(record.get(BLOCK_TABLE.GAS_LIMIT))
                        .nonce(record.get(BLOCK_TABLE.NONCE))
                        .extraData(record.get(BLOCK_TABLE.EXTRA_DATA))
                        .parentHash(record.get(BLOCK_TABLE.PARENT_HASH))
                        .uncleHash(record.get(BLOCK_TABLE.UNCLE_HASH))
                        .stateRoot(record.get(BLOCK_TABLE.STATE_ROOT))
                        .receiptsRoot(record.get(BLOCK_TABLE.RECEIPTS_ROOT))
                        .transactionsRoot(record.get(BLOCK_TABLE.TRANSACTIONS_ROOT))
                        .build())
                .collect(Collectors.toList());
    }
}
