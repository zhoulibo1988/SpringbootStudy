package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.mapper.SysUserMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description mapper
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/11 - 10:38
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
