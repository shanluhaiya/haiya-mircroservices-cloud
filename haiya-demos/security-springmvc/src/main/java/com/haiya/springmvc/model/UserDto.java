package com.haiya.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    /**
     * 用户身份信息
     */
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
