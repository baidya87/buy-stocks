package com.baidya.microservices.buystocks.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RequestInterceptor implements ClientHttpRequestInterceptor {

    private static  final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        //LOGGER.info("Inside intercept to set the clientRequestId");
        UserContext userContext = UserContextHolder.getUserContext();
        request.getHeaders().add("clientRequestId", userContext.getClientRequestId());
        return execution.execute(request, body);
    }
}
