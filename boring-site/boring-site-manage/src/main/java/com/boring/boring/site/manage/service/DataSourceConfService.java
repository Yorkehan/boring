package com.boring.boring.site.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.boring.site.manage.dto.DataSourceConfDTO;
import com.boring.common.core.util.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yorkehan
 * @Date: 2020/4/21 11:44 下午
 */

@FeignClient(value = "boring-common-codegen")
public interface DataSourceConfService {

    @RequestMapping(value = "/dsconf/page",method = RequestMethod.GET)
    Response<Page> dataSourceConfList(@RequestParam("size") Long size,@RequestParam("current") Long current);

    @RequestMapping(value = "/dsconf/getOne",method = RequestMethod.GET)
    Response<DataSourceConfDTO> getDataSourceById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/dsconf/add",method = RequestMethod.POST)
    Response<DataSourceConfDTO> addDataSourceConfList(DataSourceConfDTO dataSourceConfDTO);

    @RequestMapping(value = "/dsconf/delete",method = RequestMethod.DELETE)
    Response deleteDataSourceConfList(Integer id);

    @RequestMapping(value = "/dsconf/update",method = RequestMethod.PUT)
    Response updateDataSourceConfList(DataSourceConfDTO dataSourceConfDTO);
}
