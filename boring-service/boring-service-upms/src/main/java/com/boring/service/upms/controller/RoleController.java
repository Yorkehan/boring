package com.boring.service.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import com.boring.service.common.upms.entity.Role;
import com.boring.service.upms.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@RestController
@AllArgsConstructor
@RequestMapping("/role" )
@Api(value = "role", tags = "角色管理")
public class RoleController {

    private final  RoleService roleService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param role 角色
     * @return Responseesponse
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public Response getRolePage(Page page, Role role) {
        return Response.ok(roleService.page(page, Wrappers.query(role)));
    }


    /**
     * 通过id查询角色
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public Response getById(@PathVariable("id" ) Integer id) {
        return Response.ok(roleService.getById(id));
    }

    /**
     * 新增角色
     * @param role 角色
     * @return Response
     */
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @EnableSysLog("新增角色" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('upms_role_add')" )
    public Response save(@RequestBody Role role) {
        return Response.ok(roleService.save(role));
    }

    /**
     * 修改角色
     * @param role 角色
     * @return Response
     */
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @EnableSysLog("修改角色" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('upms_role_edit')" )
    public Response updateById(@RequestBody Role role) {
        return Response.ok(roleService.updateById(role));
    }

    /**
     * 通过id删除角色
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id删除角色", notes = "通过id删除角色")
    @EnableSysLog("通过id删除角色" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('upms_role_del')" )
    public Response removeById(@PathVariable Integer id) {
        return Response.ok(roleService.removeById(id));
    }

}
