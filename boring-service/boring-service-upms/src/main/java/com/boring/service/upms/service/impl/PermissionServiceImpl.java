package com.boring.service.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boring.service.common.upms.entity.Permission;
import com.boring.service.common.upms.vo.MenuVo;
import com.boring.service.upms.mapper.PermissionMapper;
import com.boring.service.upms.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {


    private final PermissionMapper permissionMapper;
    @Override
    public List<MenuVo> findPermissionsByRoleId(Integer id) {
        return permissionMapper.findPermissionsByRoleId(id);
    }
}
