

package com.boring.common.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.common.codegen.entity.GenConfig;
import com.boring.common.codegen.service.GeneratorService;
import com.boring.common.core.util.Response;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成器
 *
 * @author yorkehan
 * @date 2018-07-30
 */
@RestController
@AllArgsConstructor
@RequestMapping("/generator")
@Api(value = "generator", tags = "代码生成模块")
public class GeneratorController {
	private final GeneratorService generatorService;

	/**
	 * 列表
	 *
	 * @param tableName 参数集
	 * @param dsName    数据源编号
	 * @return 数据库表
	 */
	@GetMapping("/page")
	public Response getPage(Page page, String tableName, String dsName) {
		return Response.ok(generatorService.getPage(page, tableName, dsName));
	}

	/**
	 * 生成代码
	 */
	@SneakyThrows
	@PostMapping("/code")
	public void generatorCode(GenConfig genConfig, HttpServletResponse response) {
		byte[] data = generatorService.generatorCode(genConfig);
		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");

		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}
}
