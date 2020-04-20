package com.boring.center.auth.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: yorkehan
 * @Date: 2020/4/4 10:52 下午
 */
@RequestMapping
public class CodeFallBackController {
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("ftl/index");
        return modelAndView;
    }

    @RequestMapping("/github")
    public void gitHubCode(@RequestParam("code") String code){

    }
}
