package com.boring.service.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boring.service.common.upms.entity.Permission;
import com.boring.service.common.upms.vo.MenuVo;

import java.util.List;

/**
 * 权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
public interface PermissionService extends IService<Permission> {

    /**
     *
     * @param id
     * @return
     */
    List<MenuVo> findPermissionsByRoleId(Integer id);
}
