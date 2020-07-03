package com.buyou.demo.limiter.test;

import com.buyou.demo.limiter.Protected;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    @Protected("www")
    public void one() {
        System.out.println("Hahahaha");
    }
}
