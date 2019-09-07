package com.jchang.explorer.dao;

import com.jchang.explorer.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jchang.explorer.db.tables.AccountTable.ACCOUNT_TABLE;

@Slf4j
@Component
public class AccountDao {

    private final DSLContext sql;

    public AccountDao(DSLContext sql) {
        this.sql = sql;
    }

    public void updateAccounts(List<AccountDto> accounts) {
        accounts.forEach(account ->
                sql.insertInto(ACCOUNT_TABLE)
                        .values(account.getHash(), account.getType(),
                                account.getBalance(), account.getNonce())
                        .onDuplicateKeyUpdate()
                        .set(ACCOUNT_TABLE.BALANCE, account.getBalance())
                        .set(ACCOUNT_TABLE.NONCE, account.getNonce())
                        .execute());
    }
}
