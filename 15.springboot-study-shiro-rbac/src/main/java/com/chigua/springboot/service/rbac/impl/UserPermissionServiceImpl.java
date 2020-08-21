package com.chigua.springboot.service.rbac.impl;

import com.chigua.springboot.entity.rbac.Permission;
import com.chigua.springboot.mapper.UserPermissionMapper;
import com.chigua.springboot.service.rbac.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNameUserPermissionServiceImpl
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/21 12:02
 * @Version V1.0
 **/
@Service
public class UserPermissionServiceImpl implements UserPermissionService {
    @Autowired
    private UserPermissionMapper userPermissionMapper;
    @Override
    public List<Permission> findByUserName(String userName) {
        return userPermissionMapper.findByUserName(userName);
    }
}
