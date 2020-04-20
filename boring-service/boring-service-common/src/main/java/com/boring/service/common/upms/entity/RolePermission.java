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
 * 角色权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Data
@TableName("role_permission")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "角色权限")
public class RolePermission extends Model<RolePermission> {
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
    private Integer roleId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer permissionId;
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
