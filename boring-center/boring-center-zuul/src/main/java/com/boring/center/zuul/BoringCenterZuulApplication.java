package com.boring.center.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableZuulProxy
public class BoringCenterZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringCenterZuulApplication.class, args);
    }

}
