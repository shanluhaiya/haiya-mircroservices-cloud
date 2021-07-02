package com.haiya.cloud.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableHystrix
//@EnableFeignClients(basePackages = {"com.haiya.cloud.security"})
//@EnableDiscoveryClient
@SpringBootApplication
public class UAABasicServer {
    public static void main(String[] args) {
        SpringApplication.run(UAABasicServer.class, args);
    }
}
