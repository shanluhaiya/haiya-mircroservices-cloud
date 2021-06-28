package com.haiya.basic.controller;

import com.haiya.log.annotation.AuditLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @AuditLog(operation = "'新增或更新用户:' + haha")
    @GetMapping("/test")
    public String test() {
        return "test hello";
    }
}
