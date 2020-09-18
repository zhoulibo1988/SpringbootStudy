package com.chigua.springboot.oauth.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ClassNameAuthorizationServerConfig
 * @Description [授权服务配置]
 * @Author Mr.Zhou
 * @Date2020/9/18 12:00
 * @Version V1.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter  {
    /** *
     *  密码加密验证规则
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /** *
     * Authentication认证令牌管理器
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Resource
    private AuthenticationManager authenticationManager;

    /** *
     *  用户实现接口类
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private DataSource dataSource;

    /** *
     * 配置存放token的数据源
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }
    /** *  
     * 配置ClientDetails的数据源服务
     * @param 	
     * @return org.springframework.security.oauth2.provider.ClientDetailsService
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //配置认证管理器,支持密码模式
                .authenticationManager(authenticationManager)
                //用于支持刷新token
                .userDetailsService(userDetailsService)
                //配置token往数据库中写
                .tokenStore(tokenStore());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置ClientDetails数据服务, 这里会获取数据库中oauth_client_details表的认证客户的信息
        clients.withClientDetails(jdbcClientDetailsService());
    }
}
