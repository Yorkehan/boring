package com.boring.service.common.upms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 用户角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Data
@TableName("user_role")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户角色")
public class UserRole extends Model<UserRole> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Integer id;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String userId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String roleId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer state;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime createTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime updateTime;
    }
