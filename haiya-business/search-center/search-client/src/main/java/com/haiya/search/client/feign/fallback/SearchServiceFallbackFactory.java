package com.haiya.search.client.feign.fallback;

import com.fasterxml.jackson.databind.JsonNode;
import com.haiya.common.model.PageResult;
import com.haiya.search.client.feign.SearchService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * searchService降级工场
 *
 * @author qiaoguoqiang
 */
@Slf4j
public class SearchServiceFallbackFactory implements FallbackFactory<SearchService> {
    @Override
    public SearchService create(Throwable throwable) {
        return (indexName, searchDto) -> {
            log.error("通过索引{}搜索异常:{}", indexName, throwable);
            return PageResult.<JsonNode>builder().build();
        };
    }
}
