package com.jchang.explorer.dao;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.stereotype.Component;

import static com.jchang.explorer.dao.sql.BlockSqlStatements.MAX_BLOCK_NUMBER;
import static com.jchang.explorer.db.tables.BlockTable.BLOCK_TABLE;

@Slf4j
@Component
public class BlockDao {

    private final DSLContext sql;

    public BlockDao(DSLContext sql) {
        this.sql = sql;
    }

    public Long getLatestBlockNumber() {
        SelectQuery<Record> query = sql.selectQuery();
        query.addSelect(MAX_BLOCK_NUMBER);
        query.addFrom(BLOCK_TABLE);
        var fetch = query.fetch();

        return fetch.stream()
                .map(x -> x.getValue(MAX_BLOCK_NUMBER))
                .findFirst()
                .orElse(null);
    }
}
