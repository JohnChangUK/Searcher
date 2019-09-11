package com.jchang.explorer.service;

import com.jchang.explorer.constant.Constant;
import com.jchang.explorer.response.model.CoinMarketCapResponse;
import com.jchang.explorer.response.model.MarketCap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Date;

import static com.jchang.explorer.constant.Constant.COIN_MARKETCAP_API;

@Slf4j
@Service
public class MarketCapService {

    private final WebClient.Builder getWebClientBuilder;
    RestTemplate restTemplate = new RestTemplate();

    public MarketCapService(WebClient.Builder getWebClientBuilder) {
        this.getWebClientBuilder = getWebClientBuilder;
    }

    public MarketCap getMarketCap(String cryptoCurrency) {
        CoinMarketCapResponse[] response = getWebClientBuilder.build()
                .get()
                .uri(COIN_MARKETCAP_API + cryptoCurrency)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE)
                .retrieve()
                .bodyToMono(CoinMarketCapResponse[].class)
                .block();

        var forEntity = restTemplate.getForEntity(COIN_MARKETCAP_API + cryptoCurrency, CoinMarketCapResponse[].class);
        var cryptoResponse = response[0];

        return MarketCap.builder()
                .name(cryptoResponse.getName())
                .symbol(cryptoResponse.getSymbol())
                .priceUsd(new BigDecimal(cryptoResponse.getPriceUsd()).setScale(2, BigDecimal.ROUND_DOWN))
                .percentageChange24hour(new BigDecimal(cryptoResponse.getPercentChange24h()).abs())
                .marketCapUsd(new BigDecimal(cryptoResponse.getMarketCapUsd()))
                .createdAt(cryptoResponse.getLastUpdated())
                .build();
    }
}
