package com.yuan.atfu.config;

import com.yuan.atfu.exception.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author David Hong
 * @version 1.0
 * @description 异步线程池配置类
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 线程池维护线程的最少数量
        executor.setCorePoolSize(30);
        // 线程池维护线程的最大数量
        executor.setMaxPoolSize(50);
        // 缓存队列	TODO David Hong 最大同时线程只能是maxPoolSize+Queue=150 ps:发送一封邮件时间要12秒..
        executor.setQueueCapacity(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60 * 10);
        // 拒绝task的处理策略, 当pool已经达到max size的时候, 抛出异常
        executor.setThreadNamePrefix("AsyncThread-");
        // 初始化
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

}
