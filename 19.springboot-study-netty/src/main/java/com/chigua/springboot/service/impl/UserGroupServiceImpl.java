package com.chigua.springboot.service.impl;

import com.chigua.springboot.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.service.impl.UserGroupServiceImpl
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户组serviceImpl
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 15:03
 */
@Service("userGroupServiceImpl")
public class UserGroupServiceImpl implements UserGroupService {
    /**
     * 组装假数据,真实环境应该重数据库获取
     */
    HashMap<Integer, List<Integer>> userGroup = new HashMap<>(4);

    {
        List<Integer> list = Arrays.asList(1, 2);
        userGroup.put(1, list);
        userGroup.put(2, list);
        userGroup.put(3, list);
        userGroup.put(4, list);
    }
    @Override
    public List<Integer> findGroupIdByUserId(Integer userId) {
        return this.userGroup.get(userId);
    }
}
