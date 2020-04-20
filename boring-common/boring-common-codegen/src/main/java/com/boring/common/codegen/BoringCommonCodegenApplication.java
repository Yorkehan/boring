package com.boring.common.codegen;

import com.boring.common.datasource.annotation.EnableDynamicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableDynamicDataSource
@EnableFeignClients
public class BoringCommonCodegenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringCommonCodegenApplication.class, args);
    }

}
