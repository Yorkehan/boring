

package com.boring.common.log.event;


import com.boring.common.log.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author yorkehan
 * 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}
}
