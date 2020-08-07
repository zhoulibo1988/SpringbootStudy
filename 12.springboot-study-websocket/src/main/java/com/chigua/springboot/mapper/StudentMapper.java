package com.chigua.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-study-mybatis
 * ClassName: com.chigua.springboot.mapper.StudentMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description Student
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/21 - 11:20
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    int add(Student student);
    int update(Student student);
    int deleteBySno(String sno);

    Student queryStudentBySno(String sno);
}
