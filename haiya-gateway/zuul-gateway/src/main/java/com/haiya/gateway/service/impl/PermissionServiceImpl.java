package com.haiya.gateway.service.impl;

import com.haiya.common.model.SysMenu;
import com.haiya.gateway.feign.MenuService;
import com.haiya.oauth2.impl.DefaultPermissionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 请求权限判断service
 *
 * @author qiaoguoqiang
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl extends DefaultPermissionServiceImpl {
    @Resource
    private MenuService menuService;

    @Override
    public List<SysMenu> findMenuByRoleCodes(String roleCodes) {
        return menuService.findByRoleCodes(roleCodes);
    }

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        return hasPermission(authentication, request.getMethod(), request.getRequestURI());
    }
}
