package com.haiya.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 相当于applicationContext.xml文件
 * @author qiaoguoqiang
 */
@Configuration
@ComponentScan(basePackages = "com.haiya.springmvc", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
    /**
     * 再此配置除了Controller之外的其他bean, 比如: 数据库连接池、事务管理器、业务bean等
     */
}
