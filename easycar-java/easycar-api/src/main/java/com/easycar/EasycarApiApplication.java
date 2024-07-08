package com.easycar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.easycar")
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@MapperScan(basePackages = "com.easycar.mappers")
public class EasycarApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasycarApiApplication.class,args);
    }
}
