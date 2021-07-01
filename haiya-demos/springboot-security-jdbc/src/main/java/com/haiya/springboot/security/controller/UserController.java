package com.haiya.springboot.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaoguoqiang
 */
@RestController
public class UserController {
    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String loginSuccess() {
        /**
         * 获取具体登录用户名称
         */
        String username = getUsername();
        return username + "登录成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1", produces = "text/plain;charset=utf-8")
    public String r1() {
        return "资源r1";
    }

    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
    public String r2(){
        return "资源2";
    }

    private String getUsername() {
        String username = null;
        /**
         * 获取当前通过的用户身份
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /**
         * 获取用户身份
         */
        Object principal = authentication.getPrincipal();

        if (principal == null) {
            username = "匿名";
        }

        username = ((UserDetails) principal).getUsername();
        return username;
    }
}