package com.jchang.explorer.dao.sql;

import org.jooq.AggregateFunction;
import org.jooq.impl.DSL;

import static com.jchang.explorer.db.tables.BlockTable.BLOCK_TABLE;
import static org.jooq.impl.DSL.max;

public class BlockSqlStatements {
    
    public static AggregateFunction<Long> MAX_BLOCK_NUMBER = (max(BLOCK_TABLE.NUMBER));

}
