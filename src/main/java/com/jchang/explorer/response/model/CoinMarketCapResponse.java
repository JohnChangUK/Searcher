package com.jchang.explorer.response.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jchang.explorer.config.jackson.CustomDateDeserializer;

import java.util.Date;

public class CoinMarketCapResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("rank")
    private String rank;
    @JsonProperty("price_usd")
    private String priceUsd;
    @JsonProperty("price_btc")
    private String priceBtc;
    @JsonProperty("24h_volume_usd")
    private String volumeUsd24h;
    @JsonProperty("market_cap_usd")
    private String marketCapUsd;
    @JsonProperty("percent_change_24h")
    private String percentChange24h;
    @JsonProperty("last_updated")
    private Date lastUpdated;

    public CoinMarketCapResponse() {
    }

    @JsonCreator
    public CoinMarketCapResponse(@JsonProperty("id") String id,
                                 @JsonProperty("name") String name,
                                 @JsonProperty("symbol") String symbol,
                                 @JsonProperty("rank") String rank,
                                 @JsonProperty("price_usd") String priceUsd,
                                 @JsonProperty("price_btc") String priceBtc,
                                 @JsonProperty("24h_volume_usd") String volumeUsd24h,
                                 @JsonProperty("market_cap_usd") String marketCapUsd,
                                 @JsonProperty("percent_change_24h") String percentChange24h,
                                 @JsonDeserialize(using = CustomDateDeserializer.class)
                                 @JsonProperty("last_updated") Date lastUpdated) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.priceBtc = priceBtc;
        this.volumeUsd24h = volumeUsd24h;
        this.marketCapUsd = marketCapUsd;
        this.percentChange24h = percentChange24h;
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public String getVolumeUsd24h() {
        return volumeUsd24h;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }
}