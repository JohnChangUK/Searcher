package com.jchang.explorer.response.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private String lastUpdated;

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
                                 @JsonProperty("last_updated") String lastUpdated) {
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

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public void setVolumeUsd24h(String volumeUsd24h) {
        this.volumeUsd24h = volumeUsd24h;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}