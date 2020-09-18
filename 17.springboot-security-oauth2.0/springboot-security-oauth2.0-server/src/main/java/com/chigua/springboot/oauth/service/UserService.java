package com.chigua.springboot.oauth.service;

import com.chigua.springboot.oauth.entity.UserInfo;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.service.UserService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description [用户服务接口]
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:09
 */
public interface UserService {
    UserInfo getUserByName(String username);
}
