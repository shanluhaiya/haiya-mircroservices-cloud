package com.haiya.search.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.haiya.common.model.PageResult;
import com.haiya.search.model.SearchDto;

import java.io.IOException;

/**
 * @author qiaoguoqiang
 */
public interface ISearchService {
    /**
     * StringQuery通用搜索
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @return
     */
    PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto) throws IOException;
}
