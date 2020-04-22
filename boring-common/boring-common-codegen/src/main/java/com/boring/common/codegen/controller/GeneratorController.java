/*
 *    Copyright (c) 2018-2025, lengleng All  Responseights  Responseeserved.
 *
 *  Responseedistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Responseedistributions of source code must  Responseetain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *  Responseedistributions in binary form must  Responseeproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.boring.common.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.boring.common.codegen.entity.GenConfig;
import com.boring.common.codegen.service.GeneratorService;
import com.boring.common.core.util.Response;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成器
 *
 * @author lengleng
 * @date 2018-07-30
 */
@RestController
@AllArgsConstructor
@RequestMapping("/generator")
public class GeneratorController {
	private final GeneratorService generatorService;

	/**
	 * 列表
	 *
	 * @param tableName 参数集
	 * @param id        数据源编号
	 * @return 数据库表
	 */
	@GetMapping("/page")
	public  Response getPage(Page page, String tableName, Integer id) {
		return  Response.ok(generatorService.getPage(page, tableName, id));
	}

	/**
	 * 生成代码
	 */
	@SneakyThrows
	@PostMapping("/code")
	public void generatorCode(GenConfig genConfig, HttpServletResponse  response) {
		byte[] data = generatorService.generatorCode(genConfig);
		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");

		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}
}
