package com.haiya.springmvc.controller;

import com.haiya.springmvc.model.AuthenticationRequest;
import com.haiya.springmvc.model.UserDto;
import com.haiya.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto user = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY, user);
        return user.getUsername() + "登录成功";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping(value = "/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    /**
     * 测试资源1
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r1", produces = "text/plain;charset=utf-8")
    public String r1(HttpSession session) {
        String fullname = null;
        Object userObject = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userObject != null) {
            fullname = ((UserDto) userObject).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + "访问资源r1";
    }

    /**
     * 测试资源2
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
    public String r2(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名"; }
        return fullname + " 访问资源2";
    }
}
