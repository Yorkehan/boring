

package com.boring.common.log;

import com.boring.common.log.feign.RemoteLogService;
import com.boring.common.log.aspect.SysLogAspect;
import com.boring.common.log.event.SysLogListener;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yorkehan
 * @date 2019/2/1
 * 日志自动配置
 */
@EnableAsync
@AllArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LogAutoConfiguration {
	private final RemoteLogService remoteLogService;

	@Bean
	public SysLogListener sysLogListener() {
		return new SysLogListener(remoteLogService);
	}

	@Bean
	public SysLogAspect sysLogAspect() {
		return new SysLogAspect();
	}
}
