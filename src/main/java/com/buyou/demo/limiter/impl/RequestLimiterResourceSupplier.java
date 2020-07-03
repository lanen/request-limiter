package com.buyou.demo.limiter.impl;

import com.buyou.demo.limiter.ResourceSupplier;
import com.buyou.demo.limiter.SemaphoreConsumer;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class RequestLimiterResourceSupplier implements ResourceSupplier {

    private SemaphoreObjectPool semaphoreObjectPool;

    public RequestLimiterResourceSupplier(SemaphoreObjectPool semaphoreObjectPool) {
        this.semaphoreObjectPool = semaphoreObjectPool;
    }

    @Override
    public Boolean apply(String key, SemaphoreConsumer semaphoreConsumer) {
        Semaphore semaphore = null;
        try {
            semaphore = (Semaphore)semaphoreObjectPool.borrowObject(key);
            semaphoreConsumer.accept(semaphore);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != semaphore) {
                semaphoreObjectPool.returnObject(key, semaphore);
            } else {
                // 借不到对象
            }
        }
        return null;
    }
}
