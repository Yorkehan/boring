
package com.boring.common.auth.component;

import com.boring.common.auth.exception.BoringAuth2Exception;
import com.boring.common.core.constant.CommonConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.SneakyThrows;

/**
 * @author lengleng
 * @date 2018/11/16
 * <p>
 * OAuth2 异常格式化
 */
public class Auth2ExceptionSerializer extends StdSerializer<BoringAuth2Exception> {
	public Auth2ExceptionSerializer() {
		super(BoringAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(BoringAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
