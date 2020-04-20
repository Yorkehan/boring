package com.boring.common.security.handler;


import cn.hutool.json.JSONUtil;
import com.boring.common.core.util.Response;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-07-02:09
 * @Description: AccessDeniedHandler
 */

@Component
public class SourceAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONUtil.toJsonPrettyStr(Response.failed("权限不足")));
        httpServletResponse.getWriter().flush();
    }
}
