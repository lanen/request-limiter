package com.buyou.demo.limiter.spring;

import com.buyou.demo.limiter.ResourceSupplier;
import com.buyou.demo.limiter.impl.RequestLimiter;

import javax.servlet.http.HttpServletRequest;

public class RequestLimiterImpl extends RequestLimiter<HttpServletRequest> {

    public RequestLimiterImpl(String name, ResourceSupplier resourceSupplier) {
        super(name, resourceSupplier);
    }

    @Override
    public boolean test(HttpServletRequest httpServletRequest) {
        return super.test(httpServletRequest);
    }
}
