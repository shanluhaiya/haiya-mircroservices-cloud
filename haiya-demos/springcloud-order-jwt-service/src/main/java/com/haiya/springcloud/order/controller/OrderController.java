package com.haiya.springcloud.order.controller;

import com.haiya.springcloud.order.model.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaoguoqiang
 */
@RestController
public class OrderController {
    @GetMapping("/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1() {
        return getUsername() + "访问资源r1";
    }

    @GetMapping("/r2")
    @PreAuthorize("hasAuthority('p2')")
    public String r2() {
        return getUsername() + "访问资源r2";
    }

    private String getUsername() {
        UserDto user = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
}
