package com.chigua.springboot.service.rbac.impl;

import com.chigua.springboot.entity.rbac.Role;
import com.chigua.springboot.mapper.UserRoleMapper;
import com.chigua.springboot.service.rbac.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNameUserRoleServiceImpl
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/21 11:44
 * @Version V1.0
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findByUserName(String userName) {
        return userRoleMapper.findByUserName(userName);
    }
}
