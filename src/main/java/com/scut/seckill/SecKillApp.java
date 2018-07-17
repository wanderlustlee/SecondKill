package com.scut.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.scut.seckill.mapper")//这样就可以不用再mapper接口上加@Mapper
public class SecKillApp {
    public static void main(String[] args) {
        SpringApplication.run(SecKillApp.class,args);
    }
}
