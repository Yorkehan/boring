package com.boring.service.upms.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boring.service.common.upms.dto.UserInfoDto;
import com.boring.service.common.upms.entity.Role;
import com.boring.service.common.upms.entity.User;
import com.boring.service.common.upms.vo.MenuVo;
import com.boring.service.upms.mapper.UserMapper;
import com.boring.service.upms.service.PermissionService;
import com.boring.service.upms.service.RoleService;
import com.boring.service.upms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final RoleService roleService;
    private final PermissionService permissionService;

    @Override
    public UserInfoDto getUserInfo(User user) {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUser(user);
        //role id
        List<Integer> roles = roleService.findRolesByUserId(user.getId())
                .stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        userInfoDto.setRoles(ArrayUtil.toArray(roles, Integer.class));
        //权限code
        Set<String> sortPermissionCods = new HashSet<>();
        //多个角色
        roles.forEach(rId -> {
            List<String> permissionCods = permissionService.findPermissionsByRoleId(rId)
                    .stream()
                    .map(MenuVo::getPermissionCode)
                    .collect(Collectors.toList());
            //排序
            sortPermissionCods.addAll(permissionCods);
        });
        userInfoDto.setPermissions(ArrayUtil.toArray(sortPermissionCods, String.class));
        return userInfoDto;
    }
}
