package com.jchang.explorer.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Transaction extends Response<Transaction> {

    @Override
    public void setResult(Transaction result) {
        super.setResult(result);
    }
}
