

package com.boring.common.auth.exception;

import com.boring.common.auth.component.Auth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * @author yorkehan
 * @date 2018/7/8
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class MethodNotAllowedException extends BoringAuth2Exception {

	public MethodNotAllowedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
