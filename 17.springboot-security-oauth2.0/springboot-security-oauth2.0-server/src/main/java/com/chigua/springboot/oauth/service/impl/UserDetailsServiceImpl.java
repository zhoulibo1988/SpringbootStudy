package com.chigua.springboot.oauth.service.impl;/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.service.impl.UserDetailsServiceImpl
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:49
 */

import com.chigua.springboot.oauth.entity.Perm;
import com.chigua.springboot.oauth.entity.UserInfo;
import com.chigua.springboot.oauth.service.PermService;
import com.chigua.springboot.oauth.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameUserDetailsServiceImpl
 * @Description [用户详情服务实现, 提供用户数据给Spring security, 方便认证授权]
 * @Author Mr.Zhou
 * @Date2020/9/18 14:49
 * @Version V1.0
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Resource
    private PermService permService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       UserInfo user= userService.getUserByName(s);
        //创建认证权限集合(方便提供给Security认证)
        List<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        if(user!=null){
            //查询用户的权限列表
            List<Perm> permList = permService.getPermByUserId(user.getUserId());
            permList.forEach(perm -> {
                //获取用户的权限名getPermName, 创建grantedAuthority认证权限对象
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perm.getPermName());
                //添加到认证权限集合中
                grantedAuthoritiesList.add(grantedAuthority);
            });
            //新返回一个userDetails的用户对象, 交由security验证
            return new User(user.getUsername(), user.getPassword(), grantedAuthoritiesList);
        }
        return null;
    }
}
