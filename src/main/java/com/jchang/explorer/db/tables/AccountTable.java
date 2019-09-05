package com.jchang.explorer.db.tables;

import com.jchang.explorer.db.tables.records.AccountRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.sql.Timestamp;

public class AccountTable extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = -1346585582;

    /**
     * The reference instance of <code>public.account</code>
     */
    public static final AccountTable ACCOUNT_TABLE = new AccountTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>public.account.hash</code>.
     */
    public final TableField<AccountRecord, String> HASH = createField("hash", org.jooq.impl.SQLDataType.CHAR(42).nullable(false), this, "");

    /**
     * The column <code>public.account.type</code>.
     */
    public final TableField<AccountRecord, Short> TYPE = createField("type", org.jooq.impl.SQLDataType.SMALLINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("'0'::smallint", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>public.account.balance</code>.
     */
    public final TableField<AccountRecord, Long> BALANCE = createField("balance", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("'0'::bigint", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.account.nonce</code>.
     */
    public final TableField<AccountRecord, Integer> NONCE = createField("nonce", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.account.addtime</code>.
     */
    public final TableField<AccountRecord, Timestamp> ADDTIME = createField("addtime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.account.updatetime</code>.
     */
    public final TableField<AccountRecord, Timestamp> UPDATETIME = createField("updatetime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.account</code> table reference
     */
    public AccountTable() {
        this(DSL.name("account"), null);
    }

    /**
     * Create an aliased <code>public.account</code> table reference
     */
    public AccountTable(String alias) {
        this(DSL.name(alias), ACCOUNT_TABLE);
    }

    /**
     * Create an aliased <code>public.account</code> table reference
     */
    public AccountTable(Name alias) {
        this(alias, ACCOUNT_TABLE);
    }

    private AccountTable(Name alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private AccountTable(Name alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AccountTable(Table<O> child, ForeignKey<O, AccountRecord> key) {
        super(child, key, ACCOUNT_TABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountTable as(String alias) {
        return new AccountTable(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountTable as(Name alias) {
        return new AccountTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountTable rename(String name) {
        return new AccountTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountTable rename(Name name) {
        return new AccountTable(name, null);
    }
}
