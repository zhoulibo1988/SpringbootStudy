package com.chigua.springboot.service.rbac;

import com.chigua.springboot.entity.rbac.Role;

import java.util.List;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.service.rbac.UserRoleService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 角色业务接口
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 11:42
 */

public interface UserRoleService {
    /** *  
     *  根据用户名字获取角色列表
     * @param userName	用户名字
     * @return java.util.List<com.chigua.springboot.entity.rbac.Role>
     * @author Mr.zhou
     * @date 2020-08-21
     */
    List<Role> findByUserName(String userName);
}
