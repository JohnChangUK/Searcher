package com.jchang.explorer.process;

import com.jchang.explorer.dao.BlockDao;
import com.jchang.explorer.dto.AccountDto;
import com.jchang.explorer.dto.BlockDto;
import com.jchang.explorer.dto.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@EnableScheduling
public class BlockProcessor implements Processor {

    private final Web3j web3j;
    private final TransactionProcessor transactionProcessor;
    private final AccountProcessor accountProcessor;
    private final BlockDao blockDao;

    public BlockProcessor(Web3j web3j, TransactionProcessor transactionProcessor, AccountProcessor accountProcessor, BlockDao blockDao) {
        this.web3j = web3j;
        this.transactionProcessor = transactionProcessor;
        this.accountProcessor = accountProcessor;
        this.blockDao = blockDao;
    }

    @Override
    @Scheduled(fixedRate = 4000)
    public void process() throws IOException {
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

            var transactionReceiptMap = transactionProcessor.updateTransactions(transactions);
            var allAccounts = accountProcessor.getAllAddresses(accounts, transactionReceiptMap);
            accountProcessor.updateAccounts(allAccounts);

            if (!allAccounts.isEmpty()) {
                CompletableFuture.runAsync(() ->
                        accountProcessor.updateAccountsInDatabase(allAccounts));
            }
        }
    }
}
