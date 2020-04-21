

package com.boring.common.auth.exception;

import com.boring.common.auth.component.Auth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author yorkehan
 * @date 2018/7/8
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class BoringAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public BoringAuth2Exception(String msg) {
		super(msg);
	}

	public BoringAuth2Exception(String msg, Throwable t) {
		super(msg,t);
	}

	public BoringAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
