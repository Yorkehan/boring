package com.boring.service.upms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.auth.annotation.InnerApi;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import com.boring.service.common.upms.entity.User;
import com.boring.service.upms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;




/**
 * 用户
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user" )
@Api(value = "user", tags = "用户管理")
public class UserController {

    private final  UserService userService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param user 用户
     * @return Responseesponse
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
//    @PreAuthorize("hasAnyAuthority('asdasd_dadasd')")
    public Response getUserPage(Page page, User user) {
        return Response.ok(userService.page(page, Wrappers.query(user)));
    }

    @GetMapping("/auth")
    public Response getUserAuth(){
        return Response.ok(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//        return null;
    }

    /**
     * 通过id查询用户
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public Response getById(@PathVariable("id" ) Integer id) {
        return Response.ok(userService.getById(id));
    }

    /**
     * 查询用户全部信息，角色，权限
     * @param  userName
     * @return Response
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/info/{username}" )
    @InnerApi
    public Response userInfo(@PathVariable("username") String userName) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getUserName,userName);
        User user = userService.getOne(userQueryWrapper);
        if (user == null) {
            return Response.failed(String.format("用户信息为空 %s", userName));
        }
        return Response.ok(userService.getUserInfo(user));
    }
    /**
     * 新增用户
     * @param user 用户
     * @return Response
     */
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @EnableSysLog("新增用户" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('upms_user_add')" )
    public Response save(@RequestBody User user) {
        return Response.ok(userService.save(user));
    }

    /**
     * 修改用户
     * @param user 用户
     * @return Response
     */
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @EnableSysLog("修改用户" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('upms_user_edit')" )
    public Response updateById(@RequestBody User user) {
        return Response.ok(userService.updateById(user));
    }

    /**
     * 通过id删除用户
     * @param id id
     * @return Response
     */
    @ApiOperation(value = "通过id删除用户", notes = "通过id删除用户")
    @EnableSysLog("通过id删除用户" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('upms_user_del')" )
    public Response removeById(@PathVariable Integer id) {
        return Response.ok(userService.removeById(id));
    }

}
