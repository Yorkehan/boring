

package com.boring.common.codegen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boring.common.codegen.entity.GenFormConf;

/**
 * 表单管理
 *
 * @author lengleng
 * @date 2019-08-12 15:55:35
 */
public interface GenFormConfService extends IService<GenFormConf> {

	/**
	 * 获取表单信息
	 *
	 * @param dsName    数据源ID
	 * @param tableName 表名称
	 * @return
	 */
	String getForm(String dsName, String tableName);

}
