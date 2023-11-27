package com.baidya.microservices.buystocks.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import com.baidya.microservices.buystocks.util.RequestInterceptor;

import java.util.List;

@Configuration
public class BuyStocksConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptorList = restTemplate.getInterceptors();
        interceptorList.add(new RequestInterceptor());
        restTemplate.setInterceptors(interceptorList);
        return restTemplate;

    }
}
