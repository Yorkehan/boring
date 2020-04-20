package com.boring.service.common.upms.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: yorkehan
 * @Date: 2020/3/29 6:59 下午
 */
@Data
public class MenuVo implements Serializable {
    private static final long serialVersionUID = -1111998087421898081L;
    private Integer id;
    /**
     *
     */
    
    private Boolean isParent;
    /**
     *
     */
    
    private Integer parentId;
    /**
     *
     */
    
    private String permissionName;
    /**
     *
     */
    
    private String permissionCode;
    /**
     *
     */
    
    private String permissionComponent;
    /**
     *
     */
    
    private String permissionIcon;
    /**
     *
     */
    
    private String permissionPath;
    /**
     *
     */
    
    private String permissionUrl;
    /**
     *
     */
    
    private Integer permissionSort;
    /**
     *
     */
    
    private Integer state;
    /**
     *
     */
    
    private LocalDateTime createTime;
    /**
     *
     */
    
    private LocalDateTime updateTime;
}
