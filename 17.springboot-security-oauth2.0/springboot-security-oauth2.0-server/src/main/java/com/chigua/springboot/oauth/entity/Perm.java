package com.chigua.springboot.oauth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @ClassNamePerm
 * @Description
 * @Author Mr.Zhou
 * @Date2020/9/18 12:31
 * @Version V1.0
 **/
@Data
@TableName(value = "tb_perm")
public class Perm {
    @Id
    private Integer permId;

    private String permName;


    private String permNameCn;
}
