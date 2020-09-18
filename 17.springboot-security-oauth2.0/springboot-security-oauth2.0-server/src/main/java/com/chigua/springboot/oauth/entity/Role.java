package com.chigua.springboot.oauth.entity;/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.entity.Role
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:05
 */

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @ClassNameRole
 * @Description
 * @Author Mr.Zhou
 * @Date2020/9/18 14:05
 * @Version V1.0
 **/
@Data
@TableName(value = "tb_role")
public class Role {
    @Id
    private Integer roleId;

    private String roleName;

    private String roleNameCn;
}
