
package com.boring.common.auth.config;

import cn.hutool.core.util.StrUtil;

import com.boring.common.auth.annotation.InnerApi;
import com.boring.common.core.constant.SecurityConstants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 服务间接口不鉴权处理逻辑
 * @author yorkehan
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class SecurityInnerAspect {
	private final HttpServletRequest request;

	@SneakyThrows
	@Around("@annotation(innerApi)")
	public Object around(ProceedingJoinPoint point, InnerApi innerApi) {
		String header = request.getHeader(SecurityConstants.FROM);
		if (innerApi.value() && !StrUtil.equals(SecurityConstants.FROM_IN, header)) {
			log.warn("访问接口 {} 没有权限", point.getSignature().getName());
			throw new AccessDeniedException("Access is denied");
		}
		return point.proceed();
	}

}
