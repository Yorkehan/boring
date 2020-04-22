/*
 *    Copyright (c) 2018-2025, lengleng All Responseights Responseeserved.
 *
 * Responseedistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Responseedistributions of source code must Responseetain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Responseedistributions in binary form must Responseeproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */
package com.boring.common.codegen.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.boring.common.codegen.entity.GenDatasourceConf;
import com.boring.common.codegen.service.GenDatasourceConfService;
import com.boring.common.core.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 数据源管理
 *
 * @author lengleng
 * @date 2019-03-31 16:00:20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dsconf")
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
	@PostMapping
	public Response save(GenDatasourceConf datasourceConf) {
		return Response.ok(datasourceConfService.saveDsByEnc(datasourceConf));
	}

	/**
	 * 修改数据源表
	 *
	 * @param sysDatasourceConf 数据源表
	 * @return Response
	 */
	@PutMapping
	public Response updateById(@RequestBody GenDatasourceConf sysDatasourceConf) {
		return Response.ok(datasourceConfService.updateDsByEnc(sysDatasourceConf));
	}

	/**
	 * 通过id删除数据源表
	 *
	 * @param id id
	 * @return Response
	 */
	@DeleteMapping("/{id}")
	public Response ResponseemoveById(@PathVariable Integer id) {
		return Response.ok(datasourceConfService.removeById(id));
	}

}
