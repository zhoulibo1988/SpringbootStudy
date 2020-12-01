package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.ChiGuaUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.mapper.ChiGuaUserMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/27 - 15:47
 */
@Mapper
public interface ChiGuaUserMapper extends BaseMapper<ChiGuaUser> {
}
