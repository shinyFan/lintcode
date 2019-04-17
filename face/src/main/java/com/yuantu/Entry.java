package com.yuantu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by qq on 2017/7/18.
 * 项目启动入口，配置包根路径
 */
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.yuantu")
@EnableTransactionManagement
public class Entry extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Entry.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }
}
