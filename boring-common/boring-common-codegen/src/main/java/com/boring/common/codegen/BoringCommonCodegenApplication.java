package com.boring.common.codegen;

import com.boring.common.datasource.annotation.EnableDynamicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableDynamicDataSource
@EnableFeignClients
@EnableSwagger2
public class BoringCommonCodegenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringCommonCodegenApplication.class, args);
    }

}
