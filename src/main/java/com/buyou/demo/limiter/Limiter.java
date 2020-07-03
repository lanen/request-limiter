package com.buyou.demo.limiter;

public interface Limiter<T> {
    boolean test(T t);
}
