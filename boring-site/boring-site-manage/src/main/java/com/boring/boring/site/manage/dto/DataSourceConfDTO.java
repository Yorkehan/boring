package com.boring.boring.site.manage.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: yorkehan
 * @Date: 2020/4/21 10:42 下午
 * @Description:
 */
@Data
public class DataSourceConfDTO {
    private Integer id;
    private String url;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
