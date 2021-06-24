package com.haiya.log.service;

import com.haiya.log.model.Audit;

/**
 * 审计日志接口
 * @author qiaoguoqiang
 */
public interface IAuditService {
    void save(Audit audit);
}
