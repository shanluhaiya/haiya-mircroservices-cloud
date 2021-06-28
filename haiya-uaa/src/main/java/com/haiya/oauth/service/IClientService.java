package com.haiya.oauth.service;

import com.haiya.oauth.model.Client;
import com.haiya.common.model.PageResult;
import com.haiya.common.model.Result;
import com.haiya.common.service.ISuperService;

import java.util.Map;

/**
 * @author qiaoguoqiang
 */
public interface IClientService extends ISuperService<Client> {
    Result saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);

    Client loadClientByClientId(String clientId);
}
