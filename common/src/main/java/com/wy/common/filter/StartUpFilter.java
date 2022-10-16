package com.wy.common.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author HelloWorld
 * @create 2022/10/3 14:51
 * @email helloworld.dng@gmail.com
 */
public class StartUpFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        return FilterReply.DENY;
    }
}
