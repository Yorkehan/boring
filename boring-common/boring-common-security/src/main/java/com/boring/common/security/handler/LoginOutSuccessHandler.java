package com.boring.common.security.handler;

import cn.hutool.json.JSONUtil;
import com.boring.common.core.util.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-07-01:57
 * @Description: LoginOutSuccessHandler
 */

@Component
public class LoginOutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONUtil.toJsonPrettyStr(Response.failed("注销成功")));
        httpServletResponse.getWriter().flush();

    }
}
