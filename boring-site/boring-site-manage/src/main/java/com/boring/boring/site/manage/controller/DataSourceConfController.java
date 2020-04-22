package com.boring.boring.site.manage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boring.boring.site.manage.dto.DataSourceConfDTO;
import com.boring.boring.site.manage.service.DataSourceConfService;
import com.boring.common.core.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yorkehan
 * @Date: 2020/4/21 10:44 下午
 * @Description:
 */
@RestController
@RequestMapping("/dsconf")
@AllArgsConstructor
public class DataSourceConfController {

    private final DataSourceConfService dataSourceConfService;

    @GetMapping("/page")
    public Response datasources(@RequestParam("limit") Long size,@RequestParam("page") Long current){
      return dataSourceConfService.dataSourceConfList(size,current);
    }
    @PostMapping("/add")
    public Response datasourceAdd(DataSourceConfDTO dataSourceConfDTO){
        return dataSourceConfService.addDataSourceConfList(dataSourceConfDTO);
    }

    @GetMapping("/getOne")
    public Response getDataSourceById(Integer id){
        return dataSourceConfService.getDataSourceById(id);
    }
    @DeleteMapping("/delete")
    public Response deleteDataSourceConfList(Integer id){
        return dataSourceConfService.deleteDataSourceConfList(id);
    }

    @PutMapping("/update")
    public Response updateDataSourceConfList(DataSourceConfDTO dataSourceConfDTO){
        return dataSourceConfService.updateDataSourceConfList(dataSourceConfDTO);
    }
}
