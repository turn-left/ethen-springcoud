package com.ethen.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCaching //开启声明式缓存
@EnableEurekaClient
@MapperScan(basePackages = "com.ethen.app.mapper")
@SpringBootApplication
public class EthenSpringcloudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EthenSpringcloudAppApplication.class, args);
    }

}
