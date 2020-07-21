package com.chigua.springboot.controller;

import com.chigua.springboot.entity.Student;
import com.chigua.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameStudentController
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/21 11:48
 * @Version V1.0
 **/


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     *  添加
     * @param sno
     * @param name
     * @param sex
     * @return java.lang.Integer
     * @author Mr.zhou
     * @date 2020-07-21
     */
    @PostMapping("/add")
    @ResponseBody
    public Integer add(String sno, String name, String sex) {
        Student student = new Student();
        student.setName(name);
        student.setSno(sno);
        student.setSex(sex);
        int type = studentService.add(student);
        return type;
    }

    // 剩下的接口 自行实现

}
