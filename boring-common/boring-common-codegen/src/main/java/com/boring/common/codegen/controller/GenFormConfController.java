

package com.boring.common.codegen.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.codegen.entity.GenFormConf;
import com.boring.common.codegen.service.GenFormConfService;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 表单管理
 *
 * @author lengleng
 * @date 2019-08-12 15:55:35
 */
@RestController
@AllArgsConstructor
@RequestMapping("/form")
@Api(value = "form", tags = "表单管理")
public class GenFormConfController {
	private final GenFormConfService genRecordService;

	/**
	 * 分页查询
	 *
	 * @param page     分页对象
	 * @param formConf 生成记录
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public Response getGenFormConfPage(Page page, GenFormConf formConf) {
		return Response.ok(genRecordService.page(page, Wrappers.query(formConf)));
	}


	/**
	 * 通过id查询生成记录
	 *
	 * @param id id
	 * @return Response
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}")
	public Response getById(@PathVariable("id") Integer id) {
		return Response.ok(genRecordService.getById(id));
	}

	/**
	 * 通过id查询生成记录
	 *
	 * @param dsName      数据源ID
	 * @param tableName tableName
	 * @return Response
	 */
	@ApiOperation(value = "通过tableName查询表单信息")
	@GetMapping("/info")
	public Response form(String dsName, String tableName) {
		return Response.ok(genRecordService.getForm(dsName, tableName));
	}

	/**
	 * 通过id删除生成记录
	 *
	 * @param id id
	 * @return Response
	 */
	@ApiOperation(value = "通过id删除生成记录", notes = "通过id删除生成记录")
	@EnableSysLog("通过id删除生成记录")
	@DeleteMapping("/{id}")
	public Response removeById(@PathVariable Integer id) {
		return Response.ok(genRecordService.removeById(id));
	}

}
