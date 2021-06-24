package com.haiya.ribbon;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Feign统一配置
 *
 * @author qiaoguoqiang
 */
public class FeignAutoConfigure {

    /**
     * Feign 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
