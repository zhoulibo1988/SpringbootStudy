package com.chigua.springboot.shiro;


import com.chigua.springboot.entity.rbac.Permission;
import com.chigua.springboot.entity.rbac.Role;
import com.chigua.springboot.entity.rbac.TUser;
import com.chigua.springboot.service.rbac.UserPermissionService;
import com.chigua.springboot.service.rbac.UserRoleService;
import com.chigua.springboot.service.rbac.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserPermissionService userPermissionService;


    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        TUser user = (TUser) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUsername();
        System.out.println("用户" + userName + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色集
        List<Role> roleList = userRoleService.findByUserName(userName);
        Set<String> roleSet = new HashSet<>();
        roleList.forEach(role -> {
            roleSet.add(role.getName());
        });
        simpleAuthorizationInfo.setRoles(roleSet);
        //获取用户权限集
        List<Permission> permissionList =userPermissionService.findByUserName(userName);
        Set<String> permissionSet = new HashSet<>();
        permissionList.forEach(permission -> {
            permissionSet.add(permission.getName());
        });
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        TUser sysUser=userService.selectByUserName(userName);

        if(null==sysUser){
            throw new UnknownAccountException("用户名错误！");
        }else {
            if (!password.equals(sysUser.getPasswd())) {
                throw new IncorrectCredentialsException("密码错误！");
            }
            if ("0".equals(sysUser.getStatus())) {
                throw new LockedAccountException("账号已被锁定,请联系管理员！");
            }
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, password, getName());
        return info;
    }
}
