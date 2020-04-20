package com.boring.common.security.config;

import com.boring.common.security.filter.JwtAuthenticationTokenFilter;
import com.boring.common.security.handler.LoginOutSuccessHandler;
import com.boring.common.security.handler.SourceAccessDeniedHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @Author: yorkehan
 * @Date: 2020-03-27 22:32
 */
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth.eurl}")
    private String autheurl;

    private final UserDetailsService userDetailsService;

    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    private final AuthenticationFailureHandler authenticationFailureHandler;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    private final SourceAccessDeniedHandler sourceAccessDeniedHandler;

    private final LoginOutSuccessHandler loginOutSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //确保不使用任何session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                //登陆成功处理器
                .successHandler(authenticationSuccessHandler)
                //登陆失败处理器
                .failureHandler(authenticationFailureHandler)
                .and()
                //注销成功处理器
                .logout()
                .logoutSuccessHandler(loginOutSuccessHandler)
                .and()
                //请求过滤
        .authorizeRequests()
                .antMatchers("/actuator/**","/login",autheurl).permitAll()

        .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                //无权限处理器
                .accessDeniedHandler(sourceAccessDeniedHandler)
                .and()
        .csrf().disable()
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
