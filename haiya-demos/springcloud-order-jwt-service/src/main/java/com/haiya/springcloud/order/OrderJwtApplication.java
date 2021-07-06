package com.haiya.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author qiaoguoqiang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderJwtApplication.class, args);
    }
}