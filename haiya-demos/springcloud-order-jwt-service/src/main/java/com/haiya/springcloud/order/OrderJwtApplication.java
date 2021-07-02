package com.haiya.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author qiaoguoqiang
 */
// @EnableDiscoveryClient
@SpringBootApplication
public class OrderJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderJwtApplication.class, args);
    }
}