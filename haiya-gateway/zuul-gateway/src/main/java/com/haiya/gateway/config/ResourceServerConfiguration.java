package com.haiya.gateway.config;

import com.haiya.common.config.DefaultPasswordConfig;
import com.haiya.oauth2.config.DefaultResourceServerConf;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author qiaoguoqiang
 */
@Configuration
@EnableResourceServer
@Import({DefaultPasswordConfig.class})
public class ResourceServerConfiguration extends DefaultResourceServerConf {
    @Override
    public HttpSecurity setAuthenticate(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl) {
        return authorizedUrl.access("@permissionService.hasPermission(request, authentication)").and();
    }
}