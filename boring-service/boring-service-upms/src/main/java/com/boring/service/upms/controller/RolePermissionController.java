package com.boring.service.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import com.boring.service.common.upms.entity.RolePermission;
import com.boring.service.upms.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;




/**
 * 角色权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@RestController
@AllArgsConstructor
@RequestMapping("/rolepermission" )
@Api(value = "rolepermission", tags = "角色权限管理")
public class RolePermissionController {

    private final  RolePermissionService rolePermissionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param rolePermission 角色权限
     * @return Responseesponse
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
//    @PreAuthorize("hasIpAddress()")
    public Response getRolePermissionPage(Page page, RolePermission rolePermission) {
        return Response.ok(rolePermissionService.page(page, Wrappers.query(rolePermission)));
    }


    /**
     * 通过id查询角色权限
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public Response getById(@PathVariable("id" ) Integer id) {
        return Response.ok(rolePermissionService.getById(id));
    }

    /**
     * 新增角色权限
     * @param rolePermission 角色权限
     * @return Response
     */
    @ApiOperation(value = "新增角色权限", notes = "新增角色权限")
    @EnableSysLog("新增角色权限" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('upms_rolepermission_add')" )
    public Response save(@RequestBody RolePermission rolePermission) {
        return Response.ok(rolePermissionService.save(rolePermission));
    }

    /**
     * 修改角色权限
     * @param rolePermission 角色权限
     * @return Response
     */
    @ApiOperation(value = "修改角色权限", notes = "修改角色权限")
    @EnableSysLog("修改角色权限" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('upms_rolepermission_edit')" )
    public Response updateById(@RequestBody RolePermission rolePermission) {
        return Response.ok(rolePermissionService.updateById(rolePermission));
    }

    /**
     * 通过id删除角色权限
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id删除角色权限", notes = "通过id删除角色权限")
    @EnableSysLog("通过id删除角色权限" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('upms_rolepermission_del')" )
    public Response removeById(@PathVariable Integer id) {
        return Response.ok(rolePermissionService.removeById(id));
    }

}
