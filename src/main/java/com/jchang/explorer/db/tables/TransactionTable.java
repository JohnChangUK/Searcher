package com.jchang.explorer.db.tables;

import com.jchang.explorer.db.tables.records.TransactionRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.sql.Timestamp;

@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TransactionTable extends TableImpl<TransactionRecord> {

    private static final long serialVersionUID = -369255043;

    /**
     * The reference instance of <code>public.transaction</code>
     */
    public static final TransactionTable TRANSACTION_TABLE = new TransactionTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransactionRecord> getRecordType() {
        return TransactionRecord.class;
    }

    /**
     * The column <code>public.transaction.hash</code>.
     */
    public final TableField<TransactionRecord, String> HASH = createField("hash", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.transaction.block_hash</code>.
     */
    public final TableField<TransactionRecord, String> BLOCK_HASH = createField("block_hash", org.jooq.impl.SQLDataType.CHAR(66).nullable(false), this, "");

    /**
     * The column <code>public.transaction.block_number</code>.
     */
    public final TableField<TransactionRecord, Long> BLOCK_NUMBER = createField("block_number", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.transaction.from</code>.
     */
    public final TableField<TransactionRecord, String> FROM = createField("from", org.jooq.impl.SQLDataType.CHAR(42).nullable(false), this, "");

    /**
     * The column <code>public.transaction.to</code>.
     */
    public final TableField<TransactionRecord, String> TO = createField("to", org.jooq.impl.SQLDataType.CHAR(42).nullable(false), this, "");

    /**
     * The column <code>public.transaction.value</code>.
     */
    public final TableField<TransactionRecord, Long> VALUE = createField("value", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.transaction.status</code>.
     */
    public final TableField<TransactionRecord, Short> STATUS = createField("status", org.jooq.impl.SQLDataType.SMALLINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("'1'::smallint", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>public.transaction.timestamp</code>.
     */
    public final TableField<TransactionRecord, Timestamp> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.transaction.nonce</code>.
     */
    public final TableField<TransactionRecord, Integer> NONCE = createField("nonce", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.transaction.transaction_index</code>.
     */
    public final TableField<TransactionRecord, Integer> TRANSACTION_INDEX = createField("transaction_index", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.transaction.type</code>.
     */
    public final TableField<TransactionRecord, Short> TYPE = createField("type", org.jooq.impl.SQLDataType.SMALLINT.defaultValue(org.jooq.impl.DSL.field("'0'::smallint", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>public.transaction.data</code>.
     */
    public final TableField<TransactionRecord, String> DATA = createField("data", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.transaction.gas_price</code>.
     */
    public final TableField<TransactionRecord, Long> GAS_PRICE = createField("gas_price", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.transaction.gas_limit</code>.
     */
    public final TableField<TransactionRecord, Integer> GAS_LIMIT = createField("gas_limit", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.transaction.gas_used</code>.
     */
    public final TableField<TransactionRecord, Integer> GAS_USED = createField("gas_used", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.transaction.updatetime</code>.
     */
    public final TableField<TransactionRecord, Timestamp> UPDATETIME = createField("updatetime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.transaction</code> table reference
     */
    public TransactionTable() {
        this(DSL.name("transaction"), null);
    }

    /**
     * Create an aliased <code>public.transaction</code> table reference
     */
    public TransactionTable(String alias) {
        this(DSL.name(alias), TRANSACTION_TABLE);
    }

    /**
     * Create an aliased <code>public.transaction</code> table reference
     */
    public TransactionTable(Name alias) {
        this(alias, TRANSACTION_TABLE);
    }

    private TransactionTable(Name alias, Table<TransactionRecord> aliased) {
        this(alias, aliased, null);
    }

    private TransactionTable(Name alias, Table<TransactionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TransactionTable(Table<O> child, ForeignKey<O, TransactionRecord> key) {
        super(child, key, TRANSACTION_TABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionTable as(String alias) {
        return new TransactionTable(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionTable as(Name alias) {
        return new TransactionTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TransactionTable rename(String name) {
        return new TransactionTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TransactionTable rename(Name name) {
        return new TransactionTable(name, null);
    }
}
