package com.boring.service.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boring.service.common.upms.entity.Role;
import com.boring.service.upms.mapper.RoleMapper;
import com.boring.service.upms.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;
    @Override
    public List<Role> findRolesByUserId(Integer id) {
        return  roleMapper.findRolesByUserId(id);
    }
}
