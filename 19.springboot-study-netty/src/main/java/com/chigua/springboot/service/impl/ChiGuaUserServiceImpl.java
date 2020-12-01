package com.chigua.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chigua.springboot.entity.ChiGuaUser;
import com.chigua.springboot.mapper.ChiGuaUserMapper;
import com.chigua.springboot.service.ChiGuaUserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.service.impl.ChiGuaUserServiceImpl
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/27 - 15:46
 */
@Service
public class ChiGuaUserServiceImpl implements ChiGuaUserService {
    @Autowired
    ChiGuaUserMapper chiGuaUserMapper;
    @Override
    public ChiGuaUser login(ChiGuaUser chiGuaUser) {
        QueryWrapper queryWrapper= new QueryWrapper<>();
        queryWrapper.setEntity(chiGuaUser);
        return chiGuaUserMapper.selectOne(queryWrapper);
    }

    @Override
    public List<ChiGuaUser> getChiguaUserList(ChiGuaUser chiGuaUser) {
        QueryWrapper queryWrapper= new QueryWrapper<>();
        queryWrapper.ne("id",chiGuaUser.getId());
        return  chiGuaUserMapper.selectList(queryWrapper);
    }

    @Override
    public boolean addUser(ChiGuaUser chiGuaUser) {
        chiGuaUserMapper.insert(chiGuaUser);
        return true;
    }


}
