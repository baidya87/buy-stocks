package com.baidya.microservices.buystocks.util;

public class UserContextHolder {

    private static ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    public static UserContext getUserContext(){
        if(threadLocal.get() == null) {
            UserContext userContext = new UserContext();
            threadLocal.set(userContext);
        }
        return threadLocal.get();
    }
}
