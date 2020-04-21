

package com.boring.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author yorkehan
 * @date 2019/2/1
 * 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableSysLog {

	/**
	 * 描述
	 *
	 * @return {String}
	 */
	String value();
}
