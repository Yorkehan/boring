

package com.boring.common.core.util;

import com.boring.common.core.constant.CommonConstants;
import com.sun.org.apache.regexp.internal.RE;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应消息主体
 * @author yorkehan
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Response<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String msg;


	@Getter
	@Setter
	private T data;

	public static <T> Response<T> ok() {
		return restResult(null, CommonConstants.SUCCESS, null);
	}

	public static <T> Response<T> ok(String msg) {
		return restResult(null, CommonConstants.SUCCESS, msg);
	}
	public static <T> Response<T> ok(T data) {
		return restResult(data, CommonConstants.SUCCESS, null);
	}

	public static <T> Response<T> ok(T data, String msg) {
		return restResult(data, CommonConstants.SUCCESS, msg);
	}

	public static <T> Response<T> failed() {
		return restResult(null, CommonConstants.FAIL, null);
	}

	public static <T> Response<T> failed(String msg) {
		return restResult(null, CommonConstants.FAIL, msg);
	}

	public static <T> Response<T> failed(T data) {
		return restResult(data, CommonConstants.FAIL, null);
	}

	public static <T> Response<T> failed(T data, String msg) {
		return restResult(data, CommonConstants.FAIL, msg);
	}

	private static <T> Response<T> restResult(T data, int code, String msg) {
		Response<T> apiResult = new Response<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}
}

