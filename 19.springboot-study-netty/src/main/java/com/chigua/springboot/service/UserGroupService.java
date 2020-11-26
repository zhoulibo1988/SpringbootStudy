package com.chigua.springboot.service;

import java.util.List;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.service.UserGroupService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户组service
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 15:03
 */
public interface UserGroupService {

    List<Integer> findGroupIdByUserId(Integer userId);
}
