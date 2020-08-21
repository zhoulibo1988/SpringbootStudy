package com.chigua.springboot.service.rbac;

import com.chigua.springboot.entity.rbac.Permission;

import java.util.List;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.service.rbac.UserPermissionService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户权限
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 11:57
 */
public interface UserPermissionService {
    /** *
     *  根据用户名字获取用户权限
     * @param userName	用户名字
     * @return java.util.List<com.chigua.springboot.entity.rbac.Permission>
     * @author Mr.zhou
     * @date 2020-08-21
     */
    List<Permission> findByUserName(String userName);
}
