package com.boring.center.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.boring.biz.api.feign")
public class BoringCenterAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringCenterAuthApplication.class, args);
    }

}
