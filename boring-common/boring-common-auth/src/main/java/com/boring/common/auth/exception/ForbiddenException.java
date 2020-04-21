

package com.boring.common.auth.exception;

import com.boring.common.auth.component.Auth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;
/**
 * @author yorkehan
 * @date 2018/7/8
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class ForbiddenException extends BoringAuth2Exception {
	public ForbiddenException(String msg) {
		super(msg);
	}
	public ForbiddenException(String msg, Throwable t) {
		super(msg,t);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}

