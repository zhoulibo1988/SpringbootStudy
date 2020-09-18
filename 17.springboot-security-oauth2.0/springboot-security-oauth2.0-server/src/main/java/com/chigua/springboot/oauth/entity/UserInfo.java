package com.chigua.springboot.oauth.entity;/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.entity.User
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
 * @ClassNameUser
 * @Description
 * @Author Mr.Zhou
 * @Date2020/9/18 14:05
 * @Version V1.0
 **/
@Data
@TableName(value = "tb_user")
public class UserInfo {
    @Id
    private Long userId;

    private String username;

    private String password;

    private Integer age;
}
