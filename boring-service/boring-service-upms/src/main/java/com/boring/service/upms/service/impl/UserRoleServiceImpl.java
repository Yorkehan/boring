package com.boring.service.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boring.service.common.upms.entity.UserRole;
import com.boring.service.upms.mapper.UserRoleMapper;
import com.boring.service.upms.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
