package com.haiya.oauth.service;

import com.haiya.oauth.model.TokenVo;
import com.haiya.common.model.PageResult;

import java.util.Map;

/**
 * @author qiaoguoqiang
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
