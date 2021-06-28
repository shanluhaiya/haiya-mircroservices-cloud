package com.haiya.config;

import com.haiya.common.config.DefaultAsycTaskConfig;
import org.springframework.context.annotation.Configuration;

/**
 * 线程池配置、启用异步
 * @Async quartz 需要使用
 *
 * @author qiaoguoqiang
 */
@Configuration
public class AsycTaskExecutorConfig extends DefaultAsycTaskConfig {

}