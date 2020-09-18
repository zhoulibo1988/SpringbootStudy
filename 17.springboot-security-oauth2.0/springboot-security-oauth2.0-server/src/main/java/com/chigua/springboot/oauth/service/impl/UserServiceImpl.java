package com.chigua.springboot.oauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chigua.springboot.oauth.entity.UserInfo;
import com.chigua.springboot.oauth.mapper.UserMapper;
import com.chigua.springboot.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameUserService
 * @Description
 * @Author Mr.Zhou
 * @Date2020/9/18 14:43
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo getUserByName(String username) {
        QueryWrapper<UserInfo> userQueryWrapper=new QueryWrapper<>();
        UserInfo user=new UserInfo();
        user.setUsername(username);
        userQueryWrapper.setEntity(user);
        return userMapper.selectOne(userQueryWrapper);
    }
}
