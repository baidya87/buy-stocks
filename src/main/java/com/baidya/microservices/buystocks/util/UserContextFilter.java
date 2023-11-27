package com.baidya.microservices.buystocks.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       //LOGGER.info("inside doFilter");
       UserContext userContext = UserContextHolder.getUserContext();
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
       userContext.setClientRequestId(httpServletRequest.getHeader("clientRequestId"));
       LOGGER.info("Received clientRequestId {} from thread {}", userContext.getClientRequestId(), Thread.currentThread().getId());
       filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
