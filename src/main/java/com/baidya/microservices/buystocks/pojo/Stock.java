package com.baidya.microservices.buystocks.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stock {
    private long stockId;
    private String stockName;
    private float stockPrice;
}
