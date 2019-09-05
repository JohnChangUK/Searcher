package com.jchang.explorer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private String hash;
    private String blockHash;
    private long blockNumber;
    private String from;
    private String to;
    private long value;
    private int status;
    private Date timestamp;
    private int nonce;
    private int transactionIndex;
    private int type;
    private String data;
    private long gasPrice;
    private int gasLimit;
    private int gasUsed;
}