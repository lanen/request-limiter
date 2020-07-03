package com.buyou.demo.limiter;

public interface ResourceConsumer<T> {
    void consumer(T t);
}
