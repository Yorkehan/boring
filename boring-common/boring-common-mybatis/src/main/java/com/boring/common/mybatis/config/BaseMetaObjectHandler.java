package com.boring.common.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-03-22:18
 * @Description: 自动填充
 */

@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMetaObjectHandler.class);
    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        this.setFieldValByName("CREARE_TIME", LocalDateTime.now(),metaObject);
        this.setFieldValByName("UPDATE_TIME",LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");
        this.setFieldValByName("UPDATE_TIME",LocalDateTime.now(),metaObject);
    }
}
