package com.jchang.explorer.db.tables;

import com.jchang.explorer.db.tables.records.BlockRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BlockTable extends TableImpl<BlockRecord> {

    private static final long serialVersionUID = 449227647;

    /**
     * The reference instance of <code>public.block</code>
     */
    public static final BlockTable BLOCK_TABLE = new BlockTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BlockRecord> getRecordType() {
        return BlockRecord.class;
    }

    /**
     * The column <code>public.block.number</code>.
     */
    public final TableField<BlockRecord, Long> NUMBER = createField("number", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.block.hash</code>.
     */
    public final TableField<BlockRecord, String> HASH = createField("hash", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.block.timestamp</code>.
     */
    public final TableField<BlockRecord, LocalDateTime> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>public.block.miner</code>.
     */
    public final TableField<BlockRecord, String> MINER = createField("miner", org.jooq.impl.SQLDataType.CHAR(42).nullable(false), this, "");

    /**
     * The column <code>public.block.difficulty</code>.
     */
    public final TableField<BlockRecord, Long> DIFFICULTY = createField("difficulty", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.block.total_difficulty</code>.
     */
    public final TableField<BlockRecord, Long> TOTAL_DIFFICULTY = createField("total_difficulty", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.block.size</code>.
     */
    public final TableField<BlockRecord, Integer> SIZE = createField("size", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.block.gas_used</code>.
     */
    public final TableField<BlockRecord, Integer> GAS_USED = createField("gas_used", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.block.gas_limit</code>.
     */
    public final TableField<BlockRecord, Integer> GAS_LIMIT = createField("gas_limit", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.block.nonce</code>.
     */
    public final TableField<BlockRecord, String> NONCE = createField("nonce", org.jooq.impl.SQLDataType.CHAR(18).nullable(false), this, "");

    /**
     * The column <code>public.block.extra_data</code>.
     */
    public final TableField<BlockRecord, String> EXTRA_DATA = createField("extra_data", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.block.parent_hash</code>.
     */
    public final TableField<BlockRecord, String> PARENT_HASH = createField("parent_hash", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.block.uncle_hash</code>.
     */
    public final TableField<BlockRecord, String> UNCLE_HASH = createField("uncle_hash", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.block.state_root</code>.
     */
    public final TableField<BlockRecord, String> STATE_ROOT = createField("state_root", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.block.receipts_root</code>.
     */
    public final TableField<BlockRecord, String> RECEIPTS_ROOT = createField("receipts_root", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.block.transactions_root</code>.
     */
    public final TableField<BlockRecord, String> TRANSACTIONS_ROOT = createField("transactions_root", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.block.addtime</code>.
     */
    public final TableField<BlockRecord, Timestamp> ADDTIME = createField("addtime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.block.updatetime</code>.
     */
    public final TableField<BlockRecord, Timestamp> UPDATETIME = createField("updatetime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.block</code> table reference
     */
    public BlockTable() {
        this(DSL.name("block"), null);
    }

    /**
     * Create an aliased <code>public.block</code> table reference
     */
    public BlockTable(String alias) {
        this(DSL.name(alias), BLOCK_TABLE);
    }

    /**
     * Create an aliased <code>public.block</code> table reference
     */
    public BlockTable(Name alias) {
        this(alias, BLOCK_TABLE);
    }

    private BlockTable(Name alias, Table<BlockRecord> aliased) {
        this(alias, aliased, null);
    }

    private BlockTable(Name alias, Table<BlockRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BlockTable(Table<O> child, ForeignKey<O, BlockRecord> key) {
        super(child, key, BLOCK_TABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockTable as(String alias) {
        return new BlockTable(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockTable as(Name alias) {
        return new BlockTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BlockTable rename(String name) {
        return new BlockTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BlockTable rename(Name name) {
        return new BlockTable(name, null);
    }
}
