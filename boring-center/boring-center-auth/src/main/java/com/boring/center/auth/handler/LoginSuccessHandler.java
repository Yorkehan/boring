package com.boring.center.auth.handler;

import cn.hutool.json.JSONUtil;
import com.boring.common.core.util.Response;
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
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        httpServletResponse.getWriter().write(JSONUtil.toJsonPrettyStr(Response.ok("成功")));
        httpServletResponse.getWriter().flush();
    }
}
