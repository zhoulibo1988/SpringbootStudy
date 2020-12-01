package com.chigua.springboot.service;

import com.chigua.springboot.entity.ChiGuaUser;

import java.util.List;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.service.ChiGuaUserService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户服务接口
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/27 - 15:46
 */
public interface ChiGuaUserService{
    /**
     * 登录
     * @param chiGuaUser
     * @return com.chigua.springboot.entity.ChiGuaUser
     * @author Mr.zhou
     * @date 2020-11-27
     */
    public ChiGuaUser login(ChiGuaUser chiGuaUser);

    /**
     * 获取列表
     * @param chiGuaUser
     * @return java.util.List<com.chigua.springboot.entity.ChiGuaUser>
     * @author Mr.zhou
     * @date 2020-11-27
     */
    public List<ChiGuaUser> getChiguaUserList(ChiGuaUser chiGuaUser);

    /**
     * 注册
     * @param chiGuaUser
     * @return boolean
     * @author Mr.zhou
     * @date 2020-11-27
     */
    public  boolean addUser(ChiGuaUser chiGuaUser);
}


