package com.jchang.explorer.process;

import com.jchang.explorer.dao.BlockDao;
import com.jchang.explorer.dto.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@EnableScheduling
public class TransactionProcessor implements Processor {

    private final Web3j web3j;
    private final BlockDao blockDao;

    public TransactionProcessor(Web3j web3j, BlockDao blockDao) {
        this.web3j = web3j;
        this.blockDao = blockDao;
    }

    @Override
    @Scheduled(fixedRate = 4000)
    public void process() {
    }

    public Map<String, TransactionReceipt> updateTransactions(List<TransactionDto> transactions) {
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
                        .thenAccept(receipt -> transactionReceiptMap.putIfAbsent(transaction.getHash(), receipt))));

        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to update transactions: " + e.getMessage());
        }

        return transactionReceiptMap;
    }
}
