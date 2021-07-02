package com.haiya.cloud.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableHystrix
//@EnableFeignClients(basePackages = {"com.haiya.cloud.security"})
//@EnableDiscoveryClient
@SpringBootApplication
public class UAAEnhanceServer {
    public static void main(String[] args) {
        SpringApplication.run(UAAEnhanceServer.class, args);
    }
}
