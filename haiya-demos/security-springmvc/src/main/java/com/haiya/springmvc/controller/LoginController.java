package com.haiya.springmvc.controller;

import com.haiya.springmvc.model.AuthenticationRequest;
import com.haiya.springmvc.model.UserDto;
import com.haiya.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "login", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest) {
        UserDto user = authenticationService.authentication(authenticationRequest);
        return user.getUsername() + "登录成功";
    }
}
