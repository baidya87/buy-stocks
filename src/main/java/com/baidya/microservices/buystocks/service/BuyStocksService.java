package com.baidya.microservices.buystocks.service;

import com.baidya.microservices.buystocks.pojo.BuyStock;
import com.baidya.microservices.buystocks.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class BuyStocksService {
    @Autowired
    private RestTemplate restTemplate;
    public BuyStock buyStock(int quantity, long id){
        ResponseEntity<Stock> responseEntity = restTemplate.getForEntity("http://stock-gateway/stocks/"+id, Stock.class);
        Stock stock = responseEntity.getBody();
        BuyStock buyStock = new BuyStock();
        buyStock.setBuyId(new Random().nextLong(100000));
        buyStock.setStockId(stock.getStockId());
        buyStock.setStockName(stock.getStockName());
        buyStock.setStockPrice(stock.getStockPrice());
        buyStock.setSalesTax(10.5f);
        float amount = (quantity * stock.getStockPrice()) * (1.105f);
        buyStock.setTotalAmt(amount);
        return buyStock;
    }
}

