package com.haiya.oauth2.config;

import com.haiya.oauth2.properties.SecurityProperties;
import com.haiya.oauth2.properties.TokenStoreProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author qiaoguoqiang
 */
@EnableConfigurationProperties({SecurityProperties.class, TokenStoreProperties.class})
public class SecurityPropertiesConfig {
}
