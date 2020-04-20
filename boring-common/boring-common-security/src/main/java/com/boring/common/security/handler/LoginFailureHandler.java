package com.boring.common.security.handler;

import cn.hutool.json.JSONUtil;
import com.boring.common.core.util.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-06-23:58
 * @Description: FailureHandler
 */

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONUtil.toJsonPrettyStr(Response.failed("登陆失败")));
        httpServletResponse.getWriter().flush();
    }
}
