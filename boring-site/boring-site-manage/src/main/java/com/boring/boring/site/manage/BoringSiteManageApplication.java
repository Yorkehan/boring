package com.boring.boring.site.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableFeignClients
public class BoringSiteManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringSiteManageApplication.class, args);
    }

}
