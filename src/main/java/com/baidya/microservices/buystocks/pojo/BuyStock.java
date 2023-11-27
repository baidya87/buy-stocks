package com.baidya.microservices.buystocks.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuyStock {
    private long buyId;
    private long stockId;
    private String stockName;
    private float stockPrice;
    private float salesTax;
    private float totalAmt;

}
