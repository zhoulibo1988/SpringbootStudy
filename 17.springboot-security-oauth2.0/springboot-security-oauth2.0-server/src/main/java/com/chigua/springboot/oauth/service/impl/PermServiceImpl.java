package com.chigua.springboot.oauth.service.impl;

import com.chigua.springboot.oauth.entity.Perm;
import com.chigua.springboot.oauth.mapper.PermMapper;
import com.chigua.springboot.oauth.service.PermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNamePermServiceImpl
 * @Description [权限服务实现]
 * @Author Mr.Zhou
 * @Date2020/9/18 14:59
 * @Version V1.0
 **/
@Service
public class PermServiceImpl   implements PermService {
    @Resource
    private PermMapper permMapper;
    @Override
    public List<Perm> getPermByUserId(Long userId) {
        return permMapper.findAllByUserId(userId);
    }
}
