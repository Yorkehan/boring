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
 * 用户
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户")
public class User extends Model<User> {
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
    private String userName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String password;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String email;
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
