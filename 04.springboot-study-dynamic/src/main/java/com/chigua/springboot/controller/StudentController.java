package com.chigua.springboot.controller;

import com.chigua.springboot.entity.Student;
import com.chigua.springboot.entity.Student1;
import com.chigua.springboot.service.Student1Service;
import com.chigua.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private Student1Service student1Service;
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
    /**
     *  利用mybatis-puls 工具查询数据
     * @param
     * @return java.util.List<com.chigua.springboot.entity.Student>
     * @author Mr.zhou
     * @date 2020-07-21
     */
    @GetMapping("/getStudentList")
    @ResponseBody
    public List<Student> getStudentList(){
       return studentService.getStudentList();
    }

    /**
     * 多数据源测试
     * @param sno
     * @param name
     * @param sex
     * @return java.lang.Integer
     * @author Mr.zhou
     * @date 2020-07-22
     */
    @PostMapping("/addBySlave1")
    @ResponseBody
    public Integer addBySlave1(String sno, String name, String sex) {
        Student1 student = new Student1();
        student.setName(name);
        student.setSno(sno);
        student.setSex(sex);
        int type = student1Service.add(student);
        return type;
    }
    // 剩下的接口 自行实现
}
