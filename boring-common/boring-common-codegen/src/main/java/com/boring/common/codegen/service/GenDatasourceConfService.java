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
package com.boring.common.codegen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boring.common.codegen.entity.GenDatasourceConf;

/**
 * 数据源表
 *
 * @author lengleng
 * @date 2019-03-31 16:00:20
 */
public interface GenDatasourceConfService extends IService<GenDatasourceConf> {
	/**
	 * 保存数据源并且加密
	 *
	 * @param genDatasourceConf
	 * @return
	 */
	Boolean saveDsByEnc(GenDatasourceConf genDatasourceConf);

	/**
	 * 更新数据源
	 *
	 * @param genDatasourceConf
	 * @return
	 */
	Boolean updateDsByEnc(GenDatasourceConf genDatasourceConf);
}
