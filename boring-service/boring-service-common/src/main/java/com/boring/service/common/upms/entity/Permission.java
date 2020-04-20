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
 * 权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Data
@TableName("permission")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "权限")
public class Permission extends Model<Permission> {
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
    private Boolean isParent;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer parentId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String permissionName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String permissionCode;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String permissionComponent;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String permissionIcon;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String permissionPath;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String permissionUrl;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer permissionSort;
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
