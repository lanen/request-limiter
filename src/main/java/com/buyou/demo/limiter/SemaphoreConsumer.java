package com.buyou.demo.limiter;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

@FunctionalInterface
public interface SemaphoreConsumer extends Consumer<Semaphore> {
}
