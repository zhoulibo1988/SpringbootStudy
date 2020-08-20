package com.chigua.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chigua.springboot.entity.SysUser;
import com.chigua.springboot.mapper.SysUserMapper;
import com.chigua.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.service.impl.SysUserServiceImpl
 * @author Mr.zhou <ijiami.cn>
 * @description 实现类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/11 - 10:38
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByUserName(String userName) {
        SysUser sysUser=new SysUser();
        sysUser.setUserName(userName);
        QueryWrapper<SysUser> wrapper = new QueryWrapper();
        wrapper.setEntity(sysUser);
        return sysUserMapper.selectOne(wrapper);
    }
}
