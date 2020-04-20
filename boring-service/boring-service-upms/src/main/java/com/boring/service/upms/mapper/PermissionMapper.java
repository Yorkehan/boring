package com.boring.service.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boring.service.common.upms.entity.Permission;
import com.boring.service.common.upms.vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 通过角色Id获取权限
     * @param id
     * @return
     */
    List<MenuVo> findPermissionsByRoleId(@Param("roleId") Integer id);
}
