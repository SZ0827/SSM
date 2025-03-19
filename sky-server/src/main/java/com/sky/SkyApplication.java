package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//程序主入口
@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
//来自lombok作用是打印日志
@Slf4j
//开启缓存
@EnableCaching
//开启定时任务
@EnableScheduling
public class SkyApplication {
    public static void main(String[] args) {
        //加载所有bean，并开启Web服务器
        SpringApplication.run(SkyApplication.class, args);
        log.info("server started");
    }
}
