package com.boring.common.security.filter;

import com.boring.common.security.util.JwtTokenUtil;
import com.boring.common.security.service.AuthUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-07-00:05
 * @Description: JwtAuthenticationTokenFilter
 */

@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private String tokenHeader=null;

    private String tokenHead=null;


    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(tokenHeader==null){
            tokenHeader=HttpHeaders.AUTHORIZATION;
        }
        if(tokenHead==null){
            tokenHead="Bear";
        }
        String authHeader = httpServletRequest.getHeader(tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(tokenHead.length());
            if (jwtTokenUtil.validateToken(authToken)) {
                String username = jwtTokenUtil.getUsernameFromToken(authToken);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    AuthUser userDetails = (AuthUser) userDetailsService.loadUserByUsername(username);
                    if (userDetails != null) {
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
