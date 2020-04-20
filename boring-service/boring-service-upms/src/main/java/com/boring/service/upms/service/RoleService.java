package com.boring.service.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boring.service.common.upms.entity.Role;

import java.util.List;

/**
 * 角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
public interface RoleService extends IService<Role> {

    List<Role> findRolesByUserId(Integer id);
}
