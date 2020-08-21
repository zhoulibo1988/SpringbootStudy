package com.chigua.springboot.entity.rbac;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassNameUser
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/21 14:07
 * @Version V1.0
 **/
@TableName("t_user")
public class TUser implements Serializable {
    private static final long serialVersionUID = -227437593919820521L;
    private Integer id;
    private String username;
    private  String passwd;
    private Date createTime;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
