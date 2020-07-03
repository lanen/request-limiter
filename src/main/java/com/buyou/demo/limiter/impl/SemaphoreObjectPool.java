package com.buyou.demo.limiter.impl;

import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

/**
 *
 */
public class SemaphoreObjectPool extends GenericKeyedObjectPool {

    public SemaphoreObjectPool(SemaphorePooledObjectFactory factory) {
        super(factory);
    }

    public SemaphoreObjectPool(SemaphorePooledObjectFactory factory, GenericKeyedObjectPoolConfig config) {
        super(factory, config);
    }
}
