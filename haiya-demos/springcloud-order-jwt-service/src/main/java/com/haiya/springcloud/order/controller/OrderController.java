package com.haiya.springcloud.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
        return "资源r1";
    }
}
