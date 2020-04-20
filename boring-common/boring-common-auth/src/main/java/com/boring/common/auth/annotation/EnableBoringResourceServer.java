package com.boring.common.auth.annotation;

import com.boring.common.auth.config.ResourceServerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @Author: yorkehan
 * @Date: 2020/4/5 3:23 下午
 * 资源服务自动配置，封装，
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableResourceServer
@EnableGlobalMethodSecurity(proxyTargetClass = true,prePostEnabled = true)
@Import(ResourceServerAutoConfiguration.class)
public @interface EnableBoringResourceServer {
}
