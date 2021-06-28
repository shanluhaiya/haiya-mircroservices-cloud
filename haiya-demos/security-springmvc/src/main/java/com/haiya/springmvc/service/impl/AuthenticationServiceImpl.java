package com.haiya.springmvc.service.impl;

import com.haiya.springmvc.model.AuthenticationRequest;
import com.haiya.springmvc.model.UserDto;
import com.haiya.springmvc.service.AuthenticationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于Session的认证功能authentication()
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    /**
     *
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        /**
         * 校验参数是否为空
         */
        if (authenticationRequest == null
            || StringUtils.isEmpty(authenticationRequest.getPassword())
            || StringUtils.isEmpty(authenticationRequest.getUsername())) {
            throw new RuntimeException("账号和密码为空");
        }
        // 根据账号查询数据库，这里是模拟静态数据
        UserDto user = getUserDto(authenticationRequest.getUsername());
        if (user == null) {
            throw new RuntimeException("查询不到该用户");
        }
        if (!authenticationRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("账号或密码错误");
        }
        // 认证通过，范湖用户身份信息
        return user;
    }

    /**
     * 根据账户查询用户信息
     * @param username
     * @return
     */
    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }
    // 用户信息
    private Map<String, UserDto> userMap = new HashMap<>();
    {
        userMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "133433"));
        userMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "144553"));
    }
}
