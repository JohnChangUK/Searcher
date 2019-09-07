package com.jchang.explorer.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Transaction extends Response<Transaction> {

    private String hash;
    private Block block;
    private Account from;
    private Account to;
    private Integer status;
    private String value;
    private Long nonce;
    private Date timestamp;
    private String type;
    private String gasPrice;
    private String gasLimit;
    private String gasUsed;
    private Date createdAt;
    private String data;
    private Date currentTimestamp;
    private Long timeDifference;
    private String contractAddress;
    private String executionError;

    @Override
    public void setResult(Transaction result) {
        super.setResult(result);
    }
}
