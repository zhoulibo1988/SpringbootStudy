package com.chigua.springboot.service.rbac;

import com.chigua.springboot.entity.rbac.TUser;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.service.rbac.UserService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 14:12
 */
public interface UserService {

    /** *
     *  根据用户名字查询用户是否存在
     * @param userName
     * @return com.chigua.springboot.entity.SysUser
     * @author Mr.zhou
     * @date 2020-08-11
     */
    public TUser selectByUserName(String userName);
}
