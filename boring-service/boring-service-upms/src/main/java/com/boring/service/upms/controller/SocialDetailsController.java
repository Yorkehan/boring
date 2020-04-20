package com.boring.service.upms.controller;

import com.boring.common.core.util.Response;
import com.boring.service.upms.service.SocialDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yorkehan
 * @Date: 2020/4/11 5:05 下午
 * @Description:
 */
@RestController("/social")
@AllArgsConstructor
public class SocialDetailsController {


    private final SocialDetailsService socialDetailsService;
    /**
     *
     * @param type
     * @param code
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Response getUserInfo(String type,String code){
      return Response.ok(socialDetailsService.getUserInfo(type,code));
    }

}
