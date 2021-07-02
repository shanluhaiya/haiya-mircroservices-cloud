package com.haiya.cloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author qiaoguoqiang
 * @desc 授权服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 配置令牌端点的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // tokenKey这个endpoint当使用JwtToken且使用非对称加密时，资源服务用语获取公匙而开放的，这里指这个endpoint是完全公开的。
                .tokenKeyAccess("permitAll()")
                // checkToken这个endpoint完全公开
                .checkTokenAccess("permitAll()")
                // 允许表单认证
                .allowFormAuthenticationForClients()
                ;
    }

    /**
     * 配置客户端详情服务(ClientDetailsService)
     * 客户端详情信息在这里进行初始化
     * 可以将客户端详情信息写死在这里或者通过数据库来存储调取详情信息
     * ClientDetailsServiceConfigurer能够使用内存或JDBC来实现客户端详情服务(ClientDetailsService), ClientDetailsService负责查找ClientDetails,
     * 而ClientDetails有几个重要的属性:
     * - clientId: 必须，用来标识客户的Id
     * - secret: 需要值得信任的客户端，客户端安全码，如果有的话。
     * - scope: 用来限制客户端的访问范围，如果为空(默认)的话，那么客户端拥有全部的访问范围。
     * - authorizedGrantTypes: 此客户端可以使用的授权类型，默认为空。
     * - authorities: 此客户端可以使用的权限(基于Spring Security Authories)。
     * 客户端详情(Client Details)能够在应用程序运行的时候进行更新，可以通过访问底层的存储服务(例如将客户端详情存储在一个关系数据库的表中，
     * 就可以使用JdbcClientDetailsService)或者通过自己实现ClientRegistrationService接口(同时你也可以实现ClientDetailsService接口)来进行管理。
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用in-memory存储
        clients.inMemory()
                // client_id
                .withClient("c1")
                .secret(new BCryptPasswordEncoder().encode("secret"))
                .redirectUris("res1")
                /**
                 * 该client允许的授权类型:
                 * - authorization_code
                 * - password
                 * - refresh_token
                 * - implicit
                 * - client_credentials
                 */
                .authorizedGrantTypes("authorization_code",
                        "password", "client_credentials", "implicit", "refresh_token")
                // 允许的授权范围
                .scopes("all")
                .autoApprove(false)
                // 加上验证回调的地址
                .redirectUris("http://www.baidu.com");
    }

    /**
     * 配置令牌(token)的访问端点和令牌服务(Token services)
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices())
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        /**
         * 设置授权码模式的授权码如何存取
         * 暂时采用内存方式
         */
        return new InMemoryAuthorizationCodeServices();
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices service = new DefaultTokenServices();
        // 客户端详情服务
        service.setClientDetailsService(clientDetailsService);
        // 支持刷新令牌
        service.setSupportRefreshToken(true);
        service.setTokenStore(tokenStore);

        // 令牌默认有效期2小时
        service.setAccessTokenValiditySeconds(7200);
        // 刷新令牌默认有效期3天 return service;
        service.setRefreshTokenValiditySeconds(259200);
        return service;
    }
}
