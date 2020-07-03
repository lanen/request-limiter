package com.buyou.demo.limiter.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestLimiterHandlers {

    // 懒了这样写
    public static Map<String, RequestLimiterImpl> handlers = new ConcurrentHashMap<>();

}
