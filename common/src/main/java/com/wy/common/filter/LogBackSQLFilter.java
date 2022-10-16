package com.wy.common.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

/**
 * @author HelloWorld
 * @create 2022/10/3 14:22
 * @email helloworld.dng@gmail.com
 */
public class LogBackSQLFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        // 日志行增加格式话SQL语句打印
        if (event.getLoggerName().contains(MybatisPlusInterceptor.class.getName())) {
            return FilterReply.ACCEPT;
        }

        return FilterReply.DENY;
    }
}
