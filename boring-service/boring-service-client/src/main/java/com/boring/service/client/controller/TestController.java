package com.boring.service.client.controller;

import com.boring.common.core.util.Response;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yorkehan
 * @Date: 2020/4/6 12:04 下午
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/t")
    public Response test(){
        return Response.ok("success");
    }
    @RequestMapping("/auth")
    public Response test1(){
        return Response.ok(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    }
}
