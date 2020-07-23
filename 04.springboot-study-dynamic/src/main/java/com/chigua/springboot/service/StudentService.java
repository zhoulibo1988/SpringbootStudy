package com.chigua.springboot.service;

import com.chigua.springboot.entity.Student;

import java.util.List;

/**
 * ProjectName: springboot-study-mybatis
 * ClassName: com.chigua.springboot.service.impl.StudentService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/21 - 11:30
 */
public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);

    /**
     * 获取学生列表
     * @param
     * @return java.util.List<com.chigua.springboot.entity.Student>
     * @author Mr.zhou
     * @date 2020-07-21
     */
    List<Student> getStudentList();
}
