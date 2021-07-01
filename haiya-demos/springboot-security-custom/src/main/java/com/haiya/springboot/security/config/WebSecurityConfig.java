package com.haiya.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 1. 定义用户信息服务
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    /**
     * 2. 定义密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 3. 定义安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 点击自定义登录页面后跳转403的原因及解决方式
                .authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")
                .antMatchers("/r/r2").hasAnyAuthority("p2")
                .antMatchers("/r/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login-view")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success")
        ;
    }
}
