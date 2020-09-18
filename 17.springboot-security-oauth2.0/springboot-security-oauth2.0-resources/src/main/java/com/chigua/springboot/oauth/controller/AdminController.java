package com.chigua.springboot.oauth.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNameAdminController
 * @Description 管理员的接口资源
 * @Author Mr.Zhou
 * @Date2020/9/18 16:28
 * @Version V1.0
 **/
@Api(value = "管理员的接口资源",tags = "管理员的接口资源")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("")
    @ResponseBody
    public String index(){
        return "管理员接口";
    }

    @GetMapping("/select")
    @ResponseBody
    public String select(){
        return "管理员查询接口";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(){
        return "管理员删除接口";
    }
}
