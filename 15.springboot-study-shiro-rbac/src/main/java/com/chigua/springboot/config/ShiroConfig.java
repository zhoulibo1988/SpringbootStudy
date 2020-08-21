package com.chigua.springboot.config;

import com.chigua.springboot.shiro.ShiroRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.config.ShiroConfig
 *
 * @author Mr.zhou <ijiami.cn>
 * @description ShiroConfig
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/11 - 10:08
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权跳转403
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 定义filterChain，静态资源不拦截
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        // druid数据源监控页面不拦截
        filterChainDefinitionMap.put("/druid/**", "anon");
        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "anon");
        // 除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
//        filterChainDefinitionMap.put("/**", "authc");
//        user指的是用户认证通过或者配置了Remember Me记住用户登录状态后可访问
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;

    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        //记住自己
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
    @Bean
    public ShiroRealm shiroRealm(){
        // 配置Realm，需自己实现
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    /** *
     *  前端页面设置Cookie rememberMe记住自己
     * @return org.apache.shiro.web.servlet.SimpleCookie
     * @author Mr.zhou
     * @date 2020-08-20
     */
    public SimpleCookie rememberMeCookie(){
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie simpleCookie=new SimpleCookie ("rememberMe");
        simpleCookie.setMaxAge(86400);
        return simpleCookie;
    }

    /** *
     * 记住自己
     * @return org.apache.shiro.web.mgt.CookieRememberMeManager
     * @author Mr.zhou
     * @date 2020-08-20
     */
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManage=new CookieRememberMeManager();
        cookieRememberMeManage.setCookie(rememberMeCookie());
        cookieRememberMeManage.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return  cookieRememberMeManage;
    }
    
    /** *  
     * Shiro为我们提供了一些和权限相关的注解，如下所示：  要开启这些注解的使用，需要在ShiroConfig中添加如下配置：
     * @param securityManager	
     * @return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     * @author Mr.zhou
     * @date 2020-08-21
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
