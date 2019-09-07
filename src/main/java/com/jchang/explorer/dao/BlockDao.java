package com.jchang.explorer.dao;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static com.jchang.explorer.db.tables.BlockTable.BLOCK_TABLE;
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
}
