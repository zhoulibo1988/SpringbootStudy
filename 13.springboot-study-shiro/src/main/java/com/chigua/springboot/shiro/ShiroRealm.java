package com.chigua.springboot.shiro;


import com.chigua.springboot.entity.SysUser;
import com.chigua.springboot.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.shiro.ShiroRealm
 *
 * @author Mr.zhou <ijiami.cn>
 * @description ShiroRealm
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/11 - 10:23
 */

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        SysUser sysUser=sysUserService.selectByUserName(userName);

        if(null==sysUser){
            throw new UnknownAccountException("用户名错误！");
        }else {
            if (!password.equals(sysUser.getPassword())) {
                throw new IncorrectCredentialsException("密码错误！");
            }
            if (sysUser.getStatus().equals("0")) {
                throw new LockedAccountException("账号已被锁定,请联系管理员！");
            }
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, password, getName());
        return info;
    }
}
