package com.buyou.demo.limiter.spring;

import com.buyou.demo.limiter.Protected;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestLimiterInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Protected aProtected = ((HandlerMethod) handler).getMethodAnnotation(Protected.class);
        if (null != aProtected) {
            RequestLimiterImpl requestLimiter = RequestLimiterHandlers.handlers.get(aProtected.value());
            if (null != requestLimiter) {
              return requestLimiter.test(request);
            }
        }
        return true;
    }
}
