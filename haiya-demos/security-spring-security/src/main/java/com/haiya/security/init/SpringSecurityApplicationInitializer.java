package com.haiya.security.init;

import com.haiya.security.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author qiaoguoqiang
 */
public class SpringSecurityApplicationInitializer
           extends AbstractSecurityWebApplicationInitializer {
       public SpringSecurityApplicationInitializer() {
           super(WebSecurityConfig.class);
       }
}