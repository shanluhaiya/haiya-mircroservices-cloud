package com.haiya.search.client.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.haiya.common.constant.ServiceNameConstants;
import com.haiya.common.model.PageResult;
import com.haiya.search.client.feign.fallback.SearchServiceFallbackFactory;
import com.haiya.search.model.SearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author qiaoguoqiang
 */
@FeignClient(name = ServiceNameConstants.SEARCH_SERVICE, fallbackFactory = SearchServiceFallbackFactory.class, decode404 = true)
public interface SearchService {
    /**
     * 查询文档列表
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     */
    @PostMapping(value = "/search/{indexName}")
    PageResult<JsonNode> strQuery(@PathVariable("indexName") String indexName, @RequestBody SearchDto searchDto);
}
