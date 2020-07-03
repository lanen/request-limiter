package com.buyou.demo.limiter.impl;

import com.buyou.demo.limiter.LimiterOptions;
import com.buyou.demo.limiter.LimiterOptionsManager;
import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class SemaphorePooledObjectFactory extends BaseKeyedPooledObjectFactory<String, Semaphore> {

    private LimiterOptionsManager limiterOptionsManager;

    public SemaphorePooledObjectFactory(LimiterOptionsManager limiterOptionsManager) {
        this.limiterOptionsManager = limiterOptionsManager;
    }

    @Override
    public Semaphore create(String key) throws Exception {
        LimiterOptions limiterOptions = limiterOptionsManager.get(key);
        if (null == limiterOptions) {
            throw new IllegalArgumentException("key:" + key + "找不到配置项");
        }
        return new Semaphore(limiterOptions.getInitSemaphorePermits());
    }

    @Override
    public PooledObject<Semaphore> wrap(Semaphore semaphore) {
        return new DefaultPooledObject(semaphore);
    }
}
