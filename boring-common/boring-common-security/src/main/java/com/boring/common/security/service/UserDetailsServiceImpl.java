package com.boring.common.security.service;

import cn.hutool.core.util.ArrayUtil;
import com.boring.biz.api.feign.RemoteAuthUserService;
import com.boring.service.common.upms.dto.UserInfoDto;
import com.boring.service.common.upms.entity.User;
import com.boring.common.core.constant.SecurityConstants;
import com.boring.common.core.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

/**
 * @Author: yorkehan
 * @Date: 2020-03-28 11:37
 */

@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


   private final RemoteAuthUserService remoteAuthUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 可以设置缓存
         */
        Response<UserInfoDto> r = remoteAuthUserService.userInfo(username, SecurityConstants.FROM_IN);
        UserDetails userDetails = getUserDetails(r);
        return userDetails;
    }

    private UserDetails getUserDetails(Response<UserInfoDto> r){
        UserInfoDto userInfo = r.getData();
        if (userInfo==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        Set<String> dbSource=new HashSet<>(userInfo.getRoles().length);
        //判断角色是否为空
        if(ArrayUtil.isNotEmpty(userInfo.getRoles())){
            //角色
            Arrays.stream(userInfo.getRoles()).forEach(role -> dbSource.add(SecurityConstants.ROLE + role));
            //权限资源
            dbSource.addAll(Arrays.asList(userInfo.getPermissions()));
        }
        Collection<? extends GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(dbSource.toArray(new String[0]));
        User user = userInfo.getUser();
        AuthUser authUser = new AuthUser(user.getId(),user.getUserName(), user.getPassword(), true, true, true, true, authorityList);
        return authUser;
    }
}
