package com.boring.center.auth.config;

import com.boring.common.auth.component.BoringWebResponseExceptionTranslator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.security.PublicKey;

/**
 * @Author: yorkehan
 * @Date: 2020/4/4 4:37 下午
 * 认证服务器配置
 */
@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final RedisConnectionFactory redisConnectionFactory;

    private final DataSource dataSource;

    private final UserDetailsService userDetailsService;

    private final TokenEnhancer tokenEnhancer;


    AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // passwordEncoder for client secrets
        security
                //允许表单提交
                .allowFormAuthenticationForClients()
                ///oauth/check_token
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("permitAll()")

        ;
    }

    /**
     * 客户端信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        clients.withClientDetails(jdbcClientDetailsService)
        ;
    }

    /**
     * endpoints配置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
                //注入authenticationManager来支持password模式
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenEnhancer(tokenEnhancer)
                .exceptionTranslator(new BoringWebResponseExceptionTranslator())
                .pathMapping("/oauth/confirm_access", "/oauth/confirm")
                .allowedTokenEndpointRequestMethods(HttpMethod.POST)
                .reuseRefreshTokens(false)
        ;
    }
}
