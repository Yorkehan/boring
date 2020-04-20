package com.boring.service.upms.service;

import com.boring.service.common.upms.dto.UserInfoDto;

/**
 * @Author: yorkehan
 * @Date: 2020/4/11 5:11 下午
 */
public interface SocialDetailsService {
    UserInfoDto getUserInfo(String type, String code);
}
