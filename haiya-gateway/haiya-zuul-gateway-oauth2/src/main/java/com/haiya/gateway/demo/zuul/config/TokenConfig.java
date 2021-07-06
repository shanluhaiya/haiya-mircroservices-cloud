package com.haiya.gateway.demo.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {
    private String SIGNING_KEY = "uaa123";

    @Bean
    public TokenStore tokenStore() {
        /**
         * JWT令牌存储方案
         */
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        /**
         * 设置对称密匙，资源服务使用该密匙来验证
         */
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
