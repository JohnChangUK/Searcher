package com.jchang.explorer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.web3j.protocol.core.methods.response.EthBlock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String hash;
    private int type;
    private long balance;
    private int nonce;

    public static List<AccountDto> buildAccountList(EthBlock.Block ethBlock) {
        Set<AccountDto> accounts = new HashSet<>();
        accounts.add(AccountDto.builder().hash(ethBlock.getMiner()).build());

        ethBlock.getTransactions()
                .stream()
                .map(transactionResult -> (EthBlock.TransactionObject) transactionResult)
                .filter(transactionObject -> transactionObject.getTo() != null)
                .forEach(result -> accounts.add(AccountDto.builder().hash(result.getTo()).build()));

        return new ArrayList<>(accounts);
    }
}
