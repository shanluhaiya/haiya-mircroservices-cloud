package com.haiya.search.annotation;

import com.haiya.search.client.feign.fallback.SearchServiceFallbackFactory;
import com.haiya.search.client.service.impl.QueryServiceImpl;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 控制是否加载搜索中心客户端的Service
 *
 * @author
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableFeignClients(basePackages = "com.haiya")
@Import({SearchServiceFallbackFactory.class, QueryServiceImpl.class})
public @interface EnableSearchClient {

}
