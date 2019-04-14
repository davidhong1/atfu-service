package com.yuan.atfu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.yuan.atfu.mapper")
public class AtfuApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtfuApplication.class, args);
    }

}
