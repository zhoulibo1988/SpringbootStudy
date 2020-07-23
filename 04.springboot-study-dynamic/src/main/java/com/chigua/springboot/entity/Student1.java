package com.chigua.springboot.entity;

import java.io.Serializable;

/**
 * @ClassNameStudent1
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/22 16:14
 * @Version V1.0
 **/
public class Student1 implements Serializable {
    private static final long serialVersionUID = -339516038496531943L;
    private String sno;
    private String name;
    private String sex;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
