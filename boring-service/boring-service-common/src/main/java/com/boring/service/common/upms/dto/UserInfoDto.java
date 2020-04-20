package com.boring.service.common.upms.dto;

import com.boring.service.common.upms.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yorkehan
 * @Date: 2020/3/29 6:14 下午
 */
@Data
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = 3790060652176257749L;
    private User user;
    private String[] permissions;
    private Integer[] roles;
}
