package com.yuan.atfu.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

/**
 * @author David Hong
 * @version 1.0
 * @description MyBatisPlus配置类
 */
@Configuration
public class MyBatisPlusConfig implements MetaObjectHandler {

    private final static Logger logger = LoggerFactory.getLogger(MyBatisPlusConfig.class);

    /**
     * 配置分页插件
     *
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author David Hong
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        logger.debug("注册分页插件");
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件
     * 设置 dev test 环境开启
     *
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     * @author David Hong
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        // 数据库插入记录时，初始化gmtCreate、gmtModified字段
        this.setInsertFieldValByName("gmtCreate", LocalDateTime.now(), metaObject);
        this.setUpdateFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 数据库更新记录时，更新gmtModified
        this.setUpdateFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
    }

}
