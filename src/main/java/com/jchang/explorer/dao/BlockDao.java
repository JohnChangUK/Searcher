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

import java.util.List;
import java.util.stream.Collectors;

import static com.jchang.explorer.db.tables.BlockTable.BLOCK_TABLE;
import static com.jchang.explorer.dto.BlockDto.buildBlockDto;
import static org.jooq.impl.DSL.max;

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

        return buildBlockDtoList(result);
    }

    public long getBlockCount() {
        return sql.fetchCount(BLOCK_TABLE);
    }

    public List<BlockDto> getMinerBlocks(int offSet, int pageSize, String miner) {
        SelectQuery<Record> query = sql.selectQuery();
        query.addFrom(BLOCK_TABLE);
        query.addConditions(BLOCK_TABLE.MINER.eq(miner));
        query.addOrderBy(BLOCK_TABLE.MINER.desc());
        query.addLimit(pageSize);
        query.addOffset(offSet);

        return buildBlockDtoList(query.fetch());
    }

    private List<BlockDto> buildBlockDtoList(Result<Record> result) {
        return result.stream()
                .map(record -> buildBlockDto(
                        record.get(BLOCK_TABLE.NUMBER),
                        record.get(BLOCK_TABLE.HASH),
                        record.get(BLOCK_TABLE.TIMESTAMP),
                        record.get(BLOCK_TABLE.MINER),
                        record.get(BLOCK_TABLE.DIFFICULTY),
                        record.get(BLOCK_TABLE.TOTAL_DIFFICULTY),
                        record.get(BLOCK_TABLE.SIZE),
                        record.get(BLOCK_TABLE.GAS_USED),
                        record.get(BLOCK_TABLE.GAS_LIMIT),
                        record.get(BLOCK_TABLE.NONCE),
                        record.get(BLOCK_TABLE.EXTRA_DATA),
                        record.get(BLOCK_TABLE.PARENT_HASH),
                        record.get(BLOCK_TABLE.UNCLE_HASH),
                        record.get(BLOCK_TABLE.STATE_ROOT),
                        record.get(BLOCK_TABLE.RECEIPTS_ROOT),
                        record.get(BLOCK_TABLE.TRANSACTIONS_ROOT)))
                .collect(Collectors.toList());
    }
}
