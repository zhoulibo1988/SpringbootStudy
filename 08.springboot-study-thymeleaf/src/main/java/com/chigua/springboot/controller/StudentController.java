package com.chigua.springboot.controller;

import com.chigua.springboot.aspect.Log;
import com.chigua.springboot.entity.Student;
import com.chigua.springboot.result.RetCode;
import com.chigua.springboot.result.RetResult;
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
    @Log("add")
    public RetResult add(String sno, String name, String sex) {
        Student student = new Student();
        student.setName(name);
        student.setSno(sno);
        student.setSex(sex);
        int type = studentService.add(student);
        return new RetResult(type);
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

    /** *
     * 全局 错误拦截测试接口
     * @param
     * @return com.chigua.springboot.result.RetResult
     * @author Mr.zhou
     * @date 2020-07-31
     */
    @GetMapping("/exception")
    @ResponseBody
    public RetResult exception(){
       return studentService.exception();

    }

    @GetMapping("/exceptionByNull")
    @ResponseBody
    public RetResult exceptionByNull() {
        Integer a = 10;
        Integer b = null;
        Integer ass = a / b;
        return new RetResult(ass);

    }
    // 剩下的接口 自行实现
}
