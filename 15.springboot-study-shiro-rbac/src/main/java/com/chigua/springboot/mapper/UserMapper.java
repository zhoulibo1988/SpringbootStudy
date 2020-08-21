package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.rbac.TUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.mapper.UserMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 14:10
 */
@Mapper
public interface UserMapper extends BaseMapper<TUser> {
}
