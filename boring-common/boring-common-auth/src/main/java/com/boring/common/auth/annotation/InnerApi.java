package com.boring.common.auth.annotation;

import java.lang.annotation.*;

/**
 * @Author: yorkehan
 * @Date: 2020/4/5 3:14 下午
 * 内部接口注解
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InnerApi {
    /**
     * Aop统一处理
     * @return
     */
    boolean value() default true;
}
