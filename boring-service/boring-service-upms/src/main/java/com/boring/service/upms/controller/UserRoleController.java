package com.boring.service.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import com.boring.service.common.upms.entity.UserRole;
import com.boring.service.upms.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;




/**
 * 用户角色
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@RestController
@AllArgsConstructor
@RequestMapping("/userrole" )
@Api(value = "userrole", tags = "用户角色管理")
public class UserRoleController {

    private final  UserRoleService userRoleService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param userRole 用户角色
     * @return Responseesponse
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
//    @PreAuthorize("hasAnyAuthority()")
    public Response getUserRolePage(Page page, UserRole userRole) {
        return Response.ok(userRoleService.page(page, Wrappers.query(userRole)));
    }


    /**
     * 通过id查询用户角色
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public Response getById(@PathVariable("id" ) Integer id) {
        return Response.ok(userRoleService.getById(id));
    }

    /**
     * 新增用户角色
     * @param userRole 用户角色
     * @return Response
     */
    @ApiOperation(value = "新增用户角色", notes = "新增用户角色")
    @EnableSysLog("新增用户角色" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('upms_userrole_add')" )
    public Response save(@RequestBody UserRole userRole) {
        return Response.ok(userRoleService.save(userRole));
    }

    /**
     * 修改用户角色
     * @param userRole 用户角色
     * @return Response
     */
    @ApiOperation(value = "修改用户角色", notes = "修改用户角色")
    @EnableSysLog("修改用户角色" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('upms_userrole_edit')" )
    public Response updateById(@RequestBody UserRole userRole) {
        return Response.ok(userRoleService.updateById(userRole));
    }

    /**
     * 通过id删除用户角色
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id删除用户角色", notes = "通过id删除用户角色")
    @EnableSysLog("通过id删除用户角色" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('upms_userrole_del')" )
    public Response removeById(@PathVariable Integer id) {
        return Response.ok(userRoleService.removeById(id));
    }

}
