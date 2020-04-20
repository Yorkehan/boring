package com.boring.center.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableEurekaServer
public class BoringCenterEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringCenterEurekaApplication.class, args);
    }

}
