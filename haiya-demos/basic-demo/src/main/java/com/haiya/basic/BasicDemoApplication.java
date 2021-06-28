package com.haiya.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BasicDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicDemoApplication.class, args);
    }
}
