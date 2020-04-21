
package com.boring.common.codegen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boring.common.codegen.entity.GenDatasourceConf;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源表
 *
 * @author yorkehan
 * @date 2019-03-31 16:00:20
 */
@Mapper
public interface GenDatasourceConfMapper extends BaseMapper<GenDatasourceConf> {

}
