package com.jchang.explorer.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MarketCap extends Response<MarketCap> {

    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("price_usd")
    private String priceUsd;
    @JsonProperty("24h_volume_usd")
    private String marketCapUsd;
    @JsonProperty("24_hour_percentage_change")
    private String percentageChange24hour;

    @Override
    public void setResult(MarketCap result) {
        super.setResult(result);
    }
}
