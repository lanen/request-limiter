package com.buyou.demo.limiter.impl;

import com.buyou.demo.limiter.Limiter;
import com.buyou.demo.limiter.ResourceSupplier;
import com.buyou.demo.limiter.SemaphoreConsumer;

import java.util.Objects;
import java.util.concurrent.Semaphore;

/**
 *
 * @param <T>
 */
public class RequestLimiter<T> implements Limiter<T>  {

    private ResourceSupplier resourceSupplier;

    private boolean autoOpen = true;

    private boolean isHalfOpen = false;

    private boolean hasFeature = true;

    private String name;

    private KeyedSemaphoreConsumer semaphoreConsumer = new KeyedSemaphoreConsumer();

    /**
     *
     * @param resourceSupplier
     */
    public RequestLimiter(String name, ResourceSupplier resourceSupplier) {
        if (!Objects.nonNull(resourceSupplier)) {
            throw new NullPointerException("resourceSupplier is null");
        }
        this.name = name;
        this.resourceSupplier = resourceSupplier;
    }

    @Override
    public boolean test(T t) {
        if (hasFeature) {
            Runnable runnable = () -> {
                // 为所欲为
            };
            semaphoreConsumer.runnable = runnable;
            return this.resourceSupplier.apply(name, semaphoreConsumer);
        }
        return true;
    }

    /**
     *
     */
    public static class KeyedSemaphoreConsumer implements SemaphoreConsumer {

        Runnable runnable;

        @Override
        public void accept(Semaphore semaphore) {
            // 获取到信号量对象
            if (semaphore.tryAcquire()) {
                //
                try{
                    runnable.run();
                }catch (Exception e) {
                }
                semaphore.release();
            } else {
                // 进一步获取的逻辑
            }
        }
    }
}
