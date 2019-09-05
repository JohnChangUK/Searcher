package com.jchang.explorer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class BlockService {

    private final Web3j web3j;

    public BlockService(Web3j web3j) {
        this.web3j = web3j;
    }

    public EthBlockNumber getEthBlockNumber() {
        var result = new EthBlockNumber();
        try {
            result = this.web3j.ethBlockNumber()
                    .sendAsync()
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error getting Eth Block Number: ", e.getMessage());
        }
        return result;
    }

    public EthAccounts getEthAccounts() {
        EthAccounts result = new EthAccounts();
        try {
            result = this.web3j.ethAccounts().sendAsync().get();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return result;
    }
}
