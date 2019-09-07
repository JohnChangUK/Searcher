package com.jchang.explorer.process;

import com.jchang.explorer.constant.Constant;
import com.jchang.explorer.dao.AccountDao;
import com.jchang.explorer.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
@Component
@EnableScheduling
public class AccountProcessor implements Processor {

    private final Web3j web3j;
    private final AccountDao accountDao;

    public AccountProcessor(Web3j web3j, AccountDao accountDao) {
        this.web3j = web3j;
        this.accountDao = accountDao;
    }

    @Override
    @Scheduled(fixedRate = 4000)
    public void process() {
    }

    List<AccountDto> getAllAddresses(List<AccountDto> accounts, Map<String, TransactionReceipt> transactionReceiptMap) {
        Set<AccountDto> accountSet = transactionReceiptMap.values()
                .stream()
                .filter(Objects::nonNull)
                .map(receipt -> AccountDto.builder()
                        .hash(receipt.getContractAddress())
                        .type(1)
                        .build()).collect(Collectors.toSet());

        accountSet.addAll(accounts);
        return new ArrayList<>(accountSet);
    }

    void updateAccounts(List<AccountDto> accounts) {
        List<CompletableFuture> futures = new ArrayList<>();

        accounts.forEach(account -> {
            futures.add(web3j.ethGetBalance(account.getHash(),
                    DefaultBlockParameter.valueOf(Constant.LatestBlockNumberKey))
                    .sendAsync()
                    .thenAccept(balance ->
                            account.setBalance(balance.getBalance()
                                    .divide(Constant.GWeiFactor).longValue())));
            futures.add(web3j
                    .ethGetTransactionCount(account.getHash(),
                            DefaultBlockParameter.valueOf(Constant.LatestBlockNumberKey))
                    .sendAsync()
                    .thenAccept(transactionCount ->
                            account.setNonce(transactionCount.getTransactionCount().intValue())));
        });

        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to update accounts: " + e.getMessage());
        }
    }

    void updateAccountsInDatabase(List<AccountDto> accounts) {
        accountDao.updateAccounts(accounts);
    }
}
