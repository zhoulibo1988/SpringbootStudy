package com.chigua.springboot.service.impl;

import com.chigua.springboot.entity.Student;
import com.chigua.springboot.mapper.StudentMapper;
import com.chigua.springboot.result.RetResult;
import com.chigua.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNameStudentServiceImpl
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/21 11:32
 * @Version V1.0
 **/
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private   StudentMapper studentMapper;
    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentMapper.deleteBySno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        System.out.println("走了数据库");
        return this.studentMapper.queryStudentBySno(sno);
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.selectByMap(null);
    }

    @Override
    public RetResult exception() {
        int[] arr = {1,2,3};//元素只有3个
        System.out.println(arr[4]); //明显的数据越界异常
        return new RetResult("成功");
    }
}
