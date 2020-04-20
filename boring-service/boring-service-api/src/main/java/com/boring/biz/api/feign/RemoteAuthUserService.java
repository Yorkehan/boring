package com.boring.biz.api.feign;


import com.boring.common.core.constant.SecurityConstants;
import com.boring.common.core.util.Response;
import com.boring.service.common.upms.dto.UserInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 远程获取用户信息
 * @Author: yorkehan
 * @Date: 2020-03-28 14:14
 */

@FeignClient(value = "boring-service-upms")
public interface RemoteAuthUserService {

    /**
     * 密码登陆
     * @param userName
     * @param from
     * @return
     */
    @RequestMapping(value = "/user/info/{userName}",method = RequestMethod.GET)
    Response<UserInfoDto> userInfo(@PathVariable("userName") String userName,
                                   @RequestHeader(SecurityConstants.FROM) String from);

    /**
     * 第三方登陆
     * 多个参数加上@RequestParam
     * @param type
     * @param code
     * @param fromIn
     * @return
     */
    @RequestMapping(value = "/social/info",method = RequestMethod.GET)
    Response<UserInfoDto> socialInfo(@RequestParam("type") String type, @RequestParam("code")String code,
                                     @RequestHeader(SecurityConstants.FROM) String fromIn);
}
