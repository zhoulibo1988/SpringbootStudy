package com.chigua.springboot.controller;

import com.chigua.springboot.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName: springboot-study-thymeleaf
 * ClassName: com.chigua.springboot.controller.IndexController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/31 - 15:54
 */
@Controller
public class IndexController {

    @RequestMapping("/account")
    public String account(Model m) {
        List<Account> list = new ArrayList<Account>();
        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        m.addAttribute("accountList",list);
        return "account";
    }

    @RequestMapping("/index")
    public String index(Model m) {
        m.addAttribute("SpringbootStudy","SpringbootStudy");
        return "index";
    }

    @RequestMapping("/client")
    public String client(Model m) {
        m.addAttribute("SpringbootStudy","SpringbootStudy");
        return "client";
    }
}
