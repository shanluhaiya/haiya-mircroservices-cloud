package com.haiya;

import com.haiya.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 文件中心
 * @author qiaoguoqiang
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableFeignInterceptor
@SpringBootApplication
public class FileCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(FileCenterApp.class, args);
    }
}