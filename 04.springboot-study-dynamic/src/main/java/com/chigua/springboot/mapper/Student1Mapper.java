package com.chigua.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.Student1;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-study-dynamic
 * ClassName: com.chigua.springboot.mapper.Student1Mapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/22 - 16:15
 */
@Mapper

public interface Student1Mapper extends BaseMapper<Student1> {
}
