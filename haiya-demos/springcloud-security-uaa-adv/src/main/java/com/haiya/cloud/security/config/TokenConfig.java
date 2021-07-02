package com.haiya.cloud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenConfig {
    private String SIGNING_KEY = "uaa123";

    @Bean
    public TokenStore tokenStore() {
        /**
         * 使用内存存储令牌(普通令牌)
         */
        return new InMemoryTokenStore();
    }
}
