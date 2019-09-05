package com.jchang.explorer.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Account extends Response<Account> {

    private Integer rank;
    private String hash;
    private String alias;
    private String balance;
    private String percentage;
    private int txCnt;
    private int nonce;
    private Integer type;

    @Override
    public void setResult(Account result) {
        super.setResult(result);
    }
}
