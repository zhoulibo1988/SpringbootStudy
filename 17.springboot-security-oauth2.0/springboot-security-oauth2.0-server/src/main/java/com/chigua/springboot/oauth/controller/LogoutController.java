package com.chigua.springboot.oauth.controller;

import io.swagger.annotations.Api;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNameLogoutController
 * @Description [注销登录Controller层]
 * @Author Mr.Zhou
 * @Date2020/9/18 15:57
 * @Version V1.0
 **/
@Api(value = "退出登录",tags = "退出登录")
@RestController
@RequestMapping("/logout")
public class LogoutController {
    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Resource
    private TokenStore tokenStore;

    @Resource
    private HttpServletRequest request;

    /**
     * 用户注销
     * @return
     */
    @PostMapping("/user")
    @ResponseBody
    public String user(){
        return logout();
    }

    private String logout(){
        //获取前端请求头传入的Authorization
        String authHeader = request.getHeader(TOKEN_HEADER);
        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            //获取传入的access_token
            final String accessToken = authHeader.substring(TOKEN_PREFIX.length());
            final OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
            if (oAuth2AccessToken != null){
                //删除数据库中的access_token
                tokenStore.removeAccessToken(oAuth2AccessToken);
                return "注销成功!";
            }
        }
        return "注销Token不存在";
    }
}
