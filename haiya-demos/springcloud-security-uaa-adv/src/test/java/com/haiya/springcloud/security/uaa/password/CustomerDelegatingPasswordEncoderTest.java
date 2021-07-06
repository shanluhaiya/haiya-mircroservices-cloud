package com.haiya.springcloud.security.uaa.password;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class CustomerDelegatingPasswordEncoderTest {
    public static void main(String[] args) {
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        encoders.put("noop",NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder());

        DelegatingPasswordEncoder passwordEncoder1 = new DelegatingPasswordEncoder(idForEncode, encoders);
        String encodedPassword1 = passwordEncoder1.encode("password");
        System.out.println(encodedPassword1);

        DelegatingPasswordEncoder passwordEncoder2 = new DelegatingPasswordEncoder("pbkdf2", encoders);
        String encodedPassword2 = passwordEncoder2.encode("password");
        System.out.println(encodedPassword2);

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        User user = (User) users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        User admin = (User) users
                .username("admin")
                .password("password")
                .roles("USER","ADMIN")
                .build();
        System.out.println(user.getPassword());
        System.out.println(admin.getPassword());

    }
}