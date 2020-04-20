package com.boring.service.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boring.service.common.upms.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author yorkehan
 * @date 2020-03-29 15:01:58
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
