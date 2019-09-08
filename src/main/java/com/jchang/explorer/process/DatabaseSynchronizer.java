package com.jchang.explorer.process;

import com.jchang.explorer.constant.Constant;
import com.jchang.explorer.dao.AccountDao;
import com.jchang.explorer.dao.BlockDao;
import com.jchang.explorer.dao.TransactionDao;
import com.jchang.explorer.dto.AccountDto;
import com.jchang.explorer.dto.BlockDto;
import com.jchang.explorer.dto.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
@Component
@EnableScheduling
public class DatabaseSynchronizer {

    private final Web3j web3j;
    private final BlockDao blockDao;
    private final AccountDao accountDao;
    private final TransactionDao transactionDao;

    public DatabaseSynchronizer(Web3j web3j, BlockDao blockDao,
                                AccountDao accountDao, TransactionDao transactionDao) {
        this.web3j = web3j;
        this.blockDao = blockDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
    }

    @Scheduled(fixedRate = 4000)
    public void sync() throws IOException {
        Long latestBlockNumber = blockDao.getLatestBlockNumber();
        long latestEthBlockNumber = web3j.ethBlockNumber().send().getBlockNumber().longValue();
        if (latestBlockNumber == null) {
            latestBlockNumber = 0L;
        }

        for (long i = latestBlockNumber + 1; i < latestEthBlockNumber + 1; i++) {
            var ethBlock = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(
                    BigInteger.valueOf(i)), true).send().getBlock();

            var blockDto = BlockDto.buildBlock(ethBlock);
            var transactions = TransactionDto.buildTransactionList(ethBlock);
            var accounts = AccountDto.buildAccountList(ethBlock);

            var transactionReceiptMap = updateTransactions(transactions);
            var allAccounts = getAllAddresses(accounts, transactionReceiptMap);
            updateAccounts(allAccounts);

            if (!allAccounts.isEmpty()) {
                CompletableFuture.runAsync(() -> accountDao.updateAccounts(allAccounts));
            }
            if (!transactions.isEmpty()) {
                CompletableFuture.runAsync(() -> transactionDao.insert(transactions));
            }
            blockDao.insert(blockDto);
        }
    }

    private Map<String, TransactionReceipt> updateTransactions(List<TransactionDto> transactions) {
        Map<String, TransactionReceipt> transactionReceiptMap = new ConcurrentHashMap<>();
        List<CompletableFuture> futures = new ArrayList<>();

        transactions.forEach(transaction ->
                futures.add(web3j.ethGetTransactionReceipt(transaction.getHash()).sendAsync()
                        .thenApply(receipt -> {
                            var transactionReceipt = receipt.getTransactionReceipt().get();
                            transaction.setType(transactionReceipt.getContractAddress() == null ? 0 : 1);
                            transaction.setGasUsed(transactionReceipt.getGasUsed().intValue());
                            return transactionReceipt;
                        })
                        .thenAccept(receipt ->
                                transactionReceiptMap.putIfAbsent(transaction.getHash(), receipt))));

        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to update transactions: " + e.getMessage());
        }

        return transactionReceiptMap;
    }

    private void updateAccounts(List<AccountDto> accounts) {
        List<CompletableFuture> futures = new ArrayList<>();

        accounts.forEach(account -> {
            futures.add(web3j.ethGetBalance(account.getHash(),
                    DefaultBlockParameter.valueOf(Constant.LatestBlockNumberKey))
                    .sendAsync()
                    .thenAccept(balance -> account.setBalance(
                            balance.getBalance().divide(Constant.GWeiFactor).longValue())));
            futures.add(web3j
                    .ethGetTransactionCount(account.getHash(),
                            DefaultBlockParameter.valueOf(Constant.LatestBlockNumberKey))
                    .sendAsync()
                    .thenAccept(transactionCount -> account.setNonce(
                            transactionCount.getTransactionCount().intValue())));
        });

        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to update accounts: " + e.getMessage());
        }
    }

    private List<AccountDto> getAllAddresses(
            List<AccountDto> accounts, Map<String, TransactionReceipt> transactionReceiptMap) {
        Set<AccountDto> accountSet = transactionReceiptMap.values()
                .stream()
                .filter(Objects::nonNull)
                .map(receipt -> AccountDto.builder()
                        .hash(receipt.getContractAddress())
                        .type(1)
                        .build())
                .collect(Collectors.toSet());

        accountSet.addAll(accounts);
        return new ArrayList<>(accountSet);
    }
}
