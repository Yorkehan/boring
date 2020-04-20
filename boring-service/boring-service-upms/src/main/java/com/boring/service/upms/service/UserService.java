package com.boring.service.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boring.service.common.upms.dto.UserInfoDto;
import com.boring.service.common.upms.entity.User;

/**
 * 用户
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
public interface UserService extends IService<User> {

    /**
     * 获取用户信息详情
     * @param user
     * @return
     */
    UserInfoDto getUserInfo(User user);
}
