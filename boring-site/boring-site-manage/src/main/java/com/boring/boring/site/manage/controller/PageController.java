package com.boring.boring.site.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: yorkehan
 * @Date: 2020/4/21 9:08 下午
 * @Description:
 */
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index(ModelAndView model){
        return "index";
    }
    @RequestMapping("/codegen")
    public String codegen(ModelAndView model){
        return "codegen";
    }
    @RequestMapping("/datasource")
    public String datasource(ModelAndView model){
        return "datasource";
    }
    @RequestMapping("/datasource-add")
    public String datasourceAdd(ModelAndView model){
        return "datasource-add";
    }

}
