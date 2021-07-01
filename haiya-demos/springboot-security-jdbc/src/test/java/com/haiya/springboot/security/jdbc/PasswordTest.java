package com.haiya.springboot.security.jdbc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "456";
        String encodedPass = encoder.encode(password);
        System.out.println(encodedPass);
    }
}
