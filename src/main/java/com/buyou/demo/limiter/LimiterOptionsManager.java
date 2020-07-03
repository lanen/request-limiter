package com.buyou.demo.limiter;

public interface LimiterOptionsManager {

    LimiterOptions get(String key);

    void init(String key, LimiterOptions limiterOptions);

    void init(String key);
}
