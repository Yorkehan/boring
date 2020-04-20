
package com.boring.common.auth.component;


import com.boring.common.core.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author yorkehan
 * @date 2018/8/30
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerResolver {

	/**
	 * 全局异常.
	 *
	 * @param e the e
	 * @return Response
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response handleGlobalException(Exception e) {
		log.error("全局异常信息 ex={}", e.getMessage(), e);
		return Response.failed(e.getLocalizedMessage());
	}

	/**
	 * AccessDeniedException
	 *
	 * @param e the e
	 * @return Response
	 */
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Response handleAccessDeniedException(AccessDeniedException e) {
		String msg = SpringSecurityMessageSource.getAccessor()
				.getMessage("AbstractAccessDecisionManager.accessDenied"
						, e.getMessage());
		log.error("拒绝授权异常信息 ex={}", msg, e);
		return Response.failed(e.getLocalizedMessage());
	}

	/**
	 * validation Exception
	 *
	 * @param exception
	 * @return Response
	 */
	@ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handleBodyValidException(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.error("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
		return Response.failed(fieldErrors.get(0).getDefaultMessage());
	}
}
