package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.rbac.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.mapper.UserRoleMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description mapper
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 11:45
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<Role> {
    /** *  
     *  根据用户名字查询角色列表
     * @param userName	用户名字
     * @return java.util.List<com.chigua.springboot.entity.rbac.Role>
     * @author Mr.zhou
     * @date 2020-08-21
     */
    List<Role> findByUserName(String userName);
}
