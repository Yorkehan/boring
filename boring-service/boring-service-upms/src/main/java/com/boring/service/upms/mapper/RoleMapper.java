package com.boring.service.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boring.service.common.upms.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findRolesByUserId(@Param("uid") Integer id);
}
