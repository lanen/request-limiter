package com.buyou.demo.limiter.impl;

import com.buyou.demo.limiter.LimiterOptions;
import com.buyou.demo.limiter.LimiterOptionsManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class LimiterOptionsManagerImpl implements LimiterOptionsManager {

    private Map<String, LimiterOptions> cache = new ConcurrentHashMap<>();

    private Map<String, Boolean> initCache = new ConcurrentHashMap<>();
    private boolean test = false;

    @Override
    public LimiterOptions get(String key) {
        if (!test) {
            // TODO 先这样写吧，后续会修改
            testInit();
            this.test = true;
        }
        return cache.get(key);
    }

    private void testInit() {
        for (String s : this.initCache.keySet()) {
            init(s, new SimpleLimiterOptions());
        }
    }
    @Override
    public void init(String key, LimiterOptions limiterOptions) {
        cache.put(key, limiterOptions);
    }

    @Override
    public void init(String key) {
        initCache.put(key,false);
    }
}
