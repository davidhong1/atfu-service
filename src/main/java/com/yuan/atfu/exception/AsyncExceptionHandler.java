package com.yuan.atfu.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author David Hong
 * @version 1.0
 * @description 异常异常处理类handler
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("Async method has uncaught exception, params: " + params);

        if (ex instanceof AsyncException) {
            AsyncException asyncException = (AsyncException) ex;
            log.error("asyncException:" + asyncException.getMsg());
        }

        log.error("Exception :", ex);
    }

}
