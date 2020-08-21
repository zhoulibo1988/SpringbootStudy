package com.chigua.springboot.entity.rbac;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.entity.rbac.Role
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 角色
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 11:32
 */
@TableName("t_role")
public class Role implements Serializable {
    private static final long serialVersionUID = -227437593919820521L;

    private Integer id;

    private String name;

    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
