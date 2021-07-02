package com.haiya.springcloud.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @EnableResourceServer 注解自动增加了一个类型为 OAuth2AuthenticationProcessingFilter 的过滤器链
 * @author qiaoguoqiang
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {
    public static final String RESOURCE_ID = "res1";

    /**
     * 资源服务器安全配置
     * - tokenServices: ResourceServerTokenServices类的实例，用来实现令牌服务
     * - tokenStore: TokenStore类的实例，指定令牌如何访问，与tokenServices配置可选
     * - resourceId: 这个资源服务的ID, 这个属性是可选的，但是推荐设置并在授权服务中进行验证
     * - 其他的拓展属性例如tokenExtractor令牌提取器，
     *
     * ResourceServerTokenServices 是组成授权服务的另一半，如果你的授权服务和资源服务在同一个应用程序上的话，
     * 你可以使用 DefaultTokenServices ，这样的话，你就不用考虑关于实现所有必要的接口的一致性问题。
     * 如果你的资源服务器是分离开的，那么你就必须要确保能够有匹配授权服务提供的 ResourceServerTokenServices，
     * 它知道如何对令牌进行解码。
     *
     * 令牌解析方法:
     * 使用 DefaultTokenServices 在资源服务器本地配置令牌存储、解码、解析方式
     * 使用 RemoteTokenServices 资源服务器通过 HTTP 请求来解码令牌，每次都请求授权服务器端点 /oauth/check_token
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)
                // 令牌服务
                .tokenServices(tokenServices())
                // 仅基于token的授权允许访问此资源
                .stateless(true);
    }

    /**
     * HttpSecurity，和Spring Security配置类似
     * - 请求匹配器: 用来设置需要进行保护的资源路径，默认情况下是保护资源服务的全部路径
     * - 通过http.authorizeRequests()来设置受保护资源的访问规则
     * - 其他的自定义权限保护规则通过HttpSecurity来进行配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 资源服务令牌解析服务
     */
    @Bean
    public ResourceServerTokenServices tokenServices() {
        /**
         * 使用远程服务请求授权服务器校验token, 必须指定token的url, client_id, client_secret
         */
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:53020/uaa/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }
}
