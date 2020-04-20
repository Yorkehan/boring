package com.boring.common.security.handler;

import cn.hutool.json.JSONUtil;
import com.boring.common.security.util.JwtTokenUtil;
import com.boring.common.core.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-06-23:16
 * @Description: SuccessHandler
 */

@Component
@AllArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    private final JwtTokenUtil jwtTokenUtil;
    /**
     * 有效期
     */
    @Value("${jwt.expiration}")
    private Long expiration;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        jwtTokenUtil.saveToken(jwtToken,userDetails.getUsername(),expiration+100000);
        httpServletResponse.getWriter().write(JSONUtil.toJsonPrettyStr(Response.ok(jwtToken)));
        httpServletResponse.getWriter().flush();
    }
}
