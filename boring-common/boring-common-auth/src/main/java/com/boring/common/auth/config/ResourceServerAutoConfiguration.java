package com.boring.common.auth.config;

import com.boring.common.auth.component.ResourceAuthExceptionEntryPoint;
import com.sun.org.apache.regexp.internal.RE;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @Author: yorkehan
 * @Date: 2020/4/5 3:25 下午
 * @Description: 资源服务器自动配置类
 */
@ComponentScan({"com.boring.common.auth.config","com.boring.common.auth.component"})
public class ResourceServerAutoConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    PermitAllUrlProperties permitAllUrlProperties;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint;
    @Autowired
    RemoteTokenServices remoteTokenServices;

    /**
     * ResourceServer  RestTemplate负载均衡，可通过服务名称调用 认证中心
     * @return
     */
    @Bean
    @LoadBalanced
    @Primary
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != HttpStatus.BAD_REQUEST.value()) {
                    super.handleError(response);
                }
            }
        });
        return restTemplate;
    }

    /**
     * 过滤url
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();
        final ExpressionUrlAuthorizationConfigurer<HttpSecurity>.
                ExpressionInterceptUrlRegistry registry =
                http.authorizeRequests();
        permitAllUrlProperties.getIgnoreUrls().forEach(url -> registry.antMatchers(url).permitAll());
        registry.
                anyRequest().
                authenticated()
                .and()
                .csrf().disable()
        ;
    }

    /**
     * 手动设置restTemplate
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        remoteTokenServices.setRestTemplate(restTemplate);
        remoteTokenServices.setAccessTokenConverter(new DefaultAccessTokenConverter());
        resources.tokenServices(remoteTokenServices)
                .authenticationEntryPoint(resourceAuthExceptionEntryPoint);
    }
}
