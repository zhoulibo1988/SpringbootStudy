package com.chigua.springboot.service.rbac.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chigua.springboot.entity.rbac.TUser;
import com.chigua.springboot.mapper.UserMapper;
import com.chigua.springboot.service.rbac.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameUserServiceImpl
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/21 14:13
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public TUser selectByUserName(String userName) {
        TUser user=new TUser();
        user.setUsername(userName);
        QueryWrapper<TUser> wrapper = new QueryWrapper();
        wrapper.setEntity(user);
        return userMapper.selectOne(wrapper);
    }
}
