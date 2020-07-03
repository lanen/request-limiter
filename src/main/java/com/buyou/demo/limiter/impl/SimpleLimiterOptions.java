package com.buyou.demo.limiter.impl;

import com.buyou.demo.limiter.LimiterOptions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 提供一种动态配置方案
 *
 */
public class SimpleLimiterOptions implements LimiterOptions {

    private Map<Key,Object> properties = new ConcurrentHashMap<>();

    LimiterOptions.Key SEMAPHORE_PERMITS = new LimiterOptions.Key("test", 1000);

    @Override
    public int getInitSemaphorePermits() {
        Object obj =  properties.get(SEMAPHORE_PERMITS);
        if (null == obj) {
            return (Integer)SEMAPHORE_PERMITS.getDefaultValue();
        } else {
            return (Integer)obj;
        }
    }
}
