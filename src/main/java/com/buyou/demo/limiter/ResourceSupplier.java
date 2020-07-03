package com.buyou.demo.limiter;

import java.util.function.BiFunction;

@FunctionalInterface
public interface ResourceSupplier extends BiFunction<String, SemaphoreConsumer, Boolean> {
}
