
package com.boring.common.codegen.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.codegen.entity.GenDatasourceConf;
import com.boring.common.codegen.service.GenDatasourceConfService;
import com.boring.common.core.util.Response;
import com.boring.common.log.annotation.EnableSysLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 数据源管理
 *
 * @author yorkehan
 * @date 2019-03-31 16:00:20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dsconf")
@Api(value = "dsconf", tags = "数据源管理模块")
public class GenDsConfController {
	private final GenDatasourceConfService datasourceConfService;


	/**
	 * 分页查询
	 *
	 * @param page           分页对象
	 * @param datasourceConf 数据源表
	 * @return
	 */
	@GetMapping("/page")
	public Response getSysDatasourceConfPage(Page page, GenDatasourceConf datasourceConf) {
		return Response.ok(datasourceConfService.page(page, Wrappers.query(datasourceConf)));
	}

	/**
	 * 查询全部数据源
	 *
	 * @return
	 */
	@GetMapping("/list")
	public Response list() {
		return Response.ok(datasourceConfService.list());
	}


	/**
	 * 通过id查询数据源表
	 *
	 * @param id id
	 * @return Response
	 */
	@GetMapping("/{id}")
	public Response getById(@PathVariable("id") Integer id) {
		return Response.ok(datasourceConfService.getById(id));
	}

	/**
	 * 新增数据源表
	 *
	 * @param datasourceConf 数据源表
	 * @return Response
	 */
	@EnableSysLog("新增数据源表")
	@PostMapping
	public Response save(GenDatasourceConf datasourceConf) {
		return Response.ok(datasourceConfService.saveDsByEnc(datasourceConf));
	}

	/**
	 * 修改数据源表
	 *
	 * @param conf 数据源表
	 * @return Response
	 */
	@EnableSysLog("修改数据源表")
	@PutMapping
	public Response updateById(@RequestBody GenDatasourceConf conf) {
		return Response.ok(datasourceConfService.updateDsByEnc(conf));
	}

	/**
	 * 通过id删除数据源表
	 *
	 * @param id id
	 * @return Response
	 */
	@EnableSysLog("删除数据源表")
	@DeleteMapping("/{id}")
	public Response removeById(@PathVariable Integer id) {
		return Response.ok(datasourceConfService.removeByDsId(id));
	}
}
