package com.haiya.springmvc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    /**
     * 认证请求参数
     */
    private String username;
    private String password;
}
