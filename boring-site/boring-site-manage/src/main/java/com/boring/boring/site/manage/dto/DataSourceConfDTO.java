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
    /**
     * 名称
     */
    private String name;
    /**
     * jdbcurl
     */
    private String url;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;
    /**
     * 更新
     */
    private LocalDateTime updateDate;
    /**
     * 删除标记
     */

    private String delFlag;
}
