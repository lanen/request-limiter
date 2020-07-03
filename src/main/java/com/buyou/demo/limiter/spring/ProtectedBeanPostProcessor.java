package com.buyou.demo.limiter.spring;

import com.buyou.demo.limiter.LimiterOptionsManager;
import com.buyou.demo.limiter.Protected;
import com.buyou.demo.limiter.impl.RequestLimiterResourceSupplier;
import com.buyou.demo.limiter.impl.SemaphoreObjectPool;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
@Component
public class ProtectedBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private LimiterOptionsManager limiterOptionsManager;

    @Autowired
    private SemaphoreObjectPool semaphoreObjectPool;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());

        for (Method method : methods) {
            Protected aProtected = AnnotationUtils.findAnnotation(method, Protected.class);
            if (null != aProtected) {
                limiterOptionsManager.init(aProtected.value());
                // 这里可以优化
                RequestLimiterHandlers.handlers.put(aProtected.value(), new RequestLimiterImpl(aProtected.value(),
                        new RequestLimiterResourceSupplier(semaphoreObjectPool)));
            }
        }
        return bean;
    }
}
