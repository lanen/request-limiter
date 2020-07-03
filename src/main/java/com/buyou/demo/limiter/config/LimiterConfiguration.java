package com.buyou.demo.limiter.config;


import com.buyou.demo.limiter.LimiterOptionsManager;
import com.buyou.demo.limiter.impl.LimiterOptionsManagerImpl;
import com.buyou.demo.limiter.impl.SemaphoreObjectPool;
import com.buyou.demo.limiter.impl.SemaphorePooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LimiterConfiguration {



    @Bean
    public LimiterOptionsManager limiterOptionsManager() {
        return new LimiterOptionsManagerImpl();
    }

    @Bean
    public SemaphoreObjectPool semaphoreObjectPool() {
        SemaphorePooledObjectFactory factory = new SemaphorePooledObjectFactory(limiterOptionsManager());
        GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
        config.setJmxNameBase("semaphorePool");
        config.setJmxEnabled(false);
        SemaphoreObjectPool pool = new SemaphoreObjectPool(factory, config);
        return pool;
    }
}
