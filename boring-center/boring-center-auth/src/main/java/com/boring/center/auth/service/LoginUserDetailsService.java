package com.boring.center.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: yorkehan
 * @Date: 2020/4/11 4:56 下午
 */
public interface LoginUserDetailsService extends UserDetailsService {
    /**
     * 社交登陆
     * @param type
     * @param code
     * @return
     */
    UserDetails loadUserBySocial(String type,String code);
}
