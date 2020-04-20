package com.boring.service.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import com.boring.service.common.upms.entity.Permission;
import com.boring.service.upms.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 权限
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@RestController
@AllArgsConstructor
@RequestMapping("/permission" )
@Api(value = "permission", tags = "权限管理")
public class PermissionController {

    private final  PermissionService permissionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param permission 权限
     * @return Response
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public Response getPermissionPage(Page page, Permission permission) {
        return Response.ok(permissionService.page(page, Wrappers.query(permission)));
    }


    /**
     * 通过id查询权限
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public Response getById(@PathVariable("id" ) Integer id) {
        return Response.ok(permissionService.getById(id));
    }

    /**
     * 新增权限
     * @param permission 权限
     * @return Response
     */
    @ApiOperation(value = "新增权限", notes = "新增权限")
    @EnableSysLog("新增权限" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('upms_permission_add')" )
    public Response save(@RequestBody Permission permission) {
        return Response.ok(permissionService.save(permission));
    }

    /**
     * 修改权限
     * @param permission 权限
     * @return Response
     */
    @ApiOperation(value = "修改权限", notes = "修改权限")
    @EnableSysLog("修改权限" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('upms_permission_edit')" )
    public Response updateById(@RequestBody Permission permission) {
        return Response.ok(permissionService.updateById(permission));
    }

    /**
     * 通过id删除权限
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id删除权限", notes = "通过id删除权限")
    @EnableSysLog("通过id删除权限" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('upms_permission_del')" )
    public Response removeById(@PathVariable Integer id) {
        return Response.ok(permissionService.removeById(id));
    }

}
