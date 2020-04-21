

package com.boring.common.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.boring.common.auth.component.Auth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author yorkehan
 * @date 2018/7/8
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class ServerErrorException extends BoringAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
