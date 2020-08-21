package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.rbac.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.mapper.UserPermissionMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 权限业务接口
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 12:03
 */
@Mapper
public interface UserPermissionMapper extends BaseMapper<Permission> {
    /** *  
     * 根据用户名字获取用户权限
     * @param userName	用户名字
     * @return java.util.List<com.chigua.springboot.entity.rbac.Permission>
     * @author Mr.zhou
     * @date 2020-08-21
     */
    List<Permission> findByUserName(String userName);
}
