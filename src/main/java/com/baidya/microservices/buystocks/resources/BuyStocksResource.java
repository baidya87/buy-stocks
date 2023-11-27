package com.baidya.microservices.buystocks.resources;

import com.baidya.microservices.buystocks.pojo.BuyStock;
import com.baidya.microservices.buystocks.service.BuyStocksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buy-stocks")
public class BuyStocksResource {

    private final BuyStocksService buyStocksService;

    public BuyStocksResource(BuyStocksService buyStocksService) {
        this.buyStocksService = buyStocksService;
    }

    @GetMapping("/{quantity}/{id}")
    public BuyStock buyStock(@PathVariable("quantity") int quantity, @PathVariable("id") long id){
        return buyStocksService.buyStock(quantity, id);
    }

    @GetMapping("/test")
    public String testCall(){

        return "Remote call successful.";
    }

}
