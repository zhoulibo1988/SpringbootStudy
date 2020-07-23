package com.chigua.springboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.chigua.springboot.entity.Student1;
import com.chigua.springboot.mapper.Student1Mapper;
import com.chigua.springboot.service.Student1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameStudent1ServiceImpl
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/22 16:17
 * @Version V1.0
 **/
@Service("student1ServiceImpl")
@DS("slave")
public class Student1ServiceImpl implements Student1Service {
    @Autowired
   private Student1Mapper student1Mapper;
    @Override
    public int add(Student1 student1) {
        return student1Mapper.insert(student1);
    }
}
