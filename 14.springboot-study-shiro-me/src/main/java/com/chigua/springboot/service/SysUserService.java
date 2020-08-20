package com.chigua.springboot.service;

import com.chigua.springboot.entity.SysUser;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.service.SysUserService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 接口
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/11 - 10:35
 */
public interface SysUserService {
    /** *
     *  根据用户名字查询用户是否存在
     * @param userName
     * @return com.chigua.springboot.entity.SysUser
     * @author Mr.zhou
     * @date 2020-08-11
     */
    public SysUser selectByUserName(String userName);
}
