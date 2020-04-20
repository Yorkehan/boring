package com.boring.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableOAuth2Client
public class BoringServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringServiceClientApplication.class, args);
    }

}
