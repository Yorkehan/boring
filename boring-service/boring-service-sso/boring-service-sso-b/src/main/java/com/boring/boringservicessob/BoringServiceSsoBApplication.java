package com.boring.boringservicessob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @author yorkehan
 */
@SpringBootApplication
@EnableOAuth2Sso
public class BoringServiceSsoBApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringServiceSsoBApplication.class, args);
    }

}
