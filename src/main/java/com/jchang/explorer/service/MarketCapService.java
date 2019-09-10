package com.jchang.explorer.service;

import com.jchang.explorer.response.model.CoinMarketCapResponse;
import com.jchang.explorer.response.model.MarketCap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static com.jchang.explorer.constant.Constant.COIN_MARKETCAP_API;

@Slf4j
@Service
public class MarketCapService {

    private final WebClient.Builder getWebClientBuilder;

    public MarketCapService(WebClient.Builder getWebClientBuilder) {
        this.getWebClientBuilder = getWebClientBuilder;
    }

    public MarketCap getMarketCap(String cryptoCurrency) {
        CoinMarketCapResponse[] response = getWebClientBuilder.build()
                .get()
                .uri(COIN_MARKETCAP_API + cryptoCurrency)
                .accept(MediaType.APPLICATION_JSON)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE)
                .retrieve()
                .bodyToMono(CoinMarketCapResponse[].class)
                .block();

        return MarketCap.builder()
                .name(response[0].getName())
                .symbol(response[0].getSymbol())
                .priceUsd(response[0].getPriceUsd())
                .percentageChange24hour(response[0].getPercentChange24h())
                .marketCapUsd(response[0].getMarketCapUsd())
                .percentageChange24hour(response[0].getPercentChange24h())
                .build();
    }
}
