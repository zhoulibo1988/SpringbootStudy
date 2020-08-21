package com.chigua.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassNameUser
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/3 17:52
 * @Version V1.0
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 6222176558369919436L;

    private String userName;
    private int age;
    /** *  
     * @Jsonlgnore，作用在属性上，用来忽略此属性。
     * @param null
     * @return 
     * @author Mr.zhou
     * @date 2020-08-03
     */
    @JsonIgnore
    private String password;
   /** *
    *  @JsonProperty，作用在属性上，用来为JSON Key指定一个别名
    * @param null
    * @return 
    * @author Mr.zhou
    * @date 2020-08-03
    */
    @JsonProperty("bth")
    private Date birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
