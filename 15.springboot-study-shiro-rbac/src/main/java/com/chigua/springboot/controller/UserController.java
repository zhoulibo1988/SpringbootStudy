package com.chigua.springboot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassNameUserController
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/3 17:54
 * @Version V1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequiresPermissions("user:user")
    @RequestMapping("/list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        return "user";
    }
    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model) {
        model.addAttribute("value", "新增用户");
        return "user";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        return "user";
    }
}
