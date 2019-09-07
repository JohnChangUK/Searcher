package com.jchang.explorer.dto;

import com.jchang.explorer.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.web3j.protocol.core.methods.response.EthBlock;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
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

    public static List<TransactionDto> buildTransactionList(EthBlock.Block ethBlock) {
        List<EthBlock.TransactionObject> transactionObject =
                ethBlock.getTransactions()
                .stream()
                .map(transactionResult -> (EthBlock.TransactionObject) transactionResult)
                .collect(Collectors.toList());

        return transactionObject.stream()
                .map(txObject -> TransactionDto.toTransactionDto(txObject, ethBlock))
                .collect(Collectors.toList());
    }

    private static TransactionDto toTransactionDto(EthBlock.TransactionObject transaction, EthBlock.Block ethBlock) {
        return TransactionDto.builder()
                .hash(transaction.getHash())
                .blockHash(transaction.getBlockHash())
                .blockNumber(transaction.getBlockNumber().longValue())
                .from(transaction.getFrom())
                .to(transaction.getTo())
                .value(transaction.getValue().divide(Constant.GWeiFactor).longValue())
                .timestamp(new Date(ethBlock.getTimestamp().longValue() * Constant.TimestampFactor))
                .nonce(transaction.getNonce().intValue())
                .transactionIndex(transaction.getTransactionIndex().intValue())
                .data(transaction.getInput())
                .gasPrice(transaction.getGasPrice().longValue())
                .gasLimit(transaction.getGas().intValue())
                .build();
    }
}
