package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-study-aop
 * ClassName: com.chigua.springboot.mapper.SysLogMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description aop mapper
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/30 - 14:59
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
}
