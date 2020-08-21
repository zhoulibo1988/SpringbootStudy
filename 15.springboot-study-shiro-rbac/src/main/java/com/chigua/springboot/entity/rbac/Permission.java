package com.chigua.springboot.entity.rbac;


import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * ProjectName: springboot-study-shiro-rbac
 * ClassName: com.chigua.springboot.entity.rbac.Permission
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 权限表
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/21 - 11:36
 */
@TableName("t_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = -227437593919820521L;

    private Integer id;

    private String url;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
