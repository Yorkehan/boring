package com.boring.service.upms;

import com.boring.common.auth.annotation.EnableBoringResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableBoringResourceServer
public class BoringServiceUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringServiceUpmsApplication.class, args);
    }

}
