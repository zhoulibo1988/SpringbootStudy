package com.chigua.springboot.controller;

import com.chigua.springboot.entity.ChiGuaUser;
import com.chigua.springboot.service.UserGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.controller.ChiGuaImController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 吃瓜IM聊天入口类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 15:26
 */
@Api(value = "吃瓜IM聊天服务", tags = "吃瓜IM聊天服务")
@Controller
public class ChiGuaImController {
    @Value("${netty.ws}")
    private String ws;

    @Autowired
    UserGroupService userGroupService;

    /**
     * 登录页面
     */
    @ApiOperation(value = "login", notes = "登录页面")
    @RequestMapping("/login")
    public String login() {
        return "test/login";
    }

    /**
     * 登录后跳转到测试主页
     */
    @ApiOperation(value = "login.do", notes = "登录后跳转到测试主页")
    @PostMapping("/login.do")
    public String login(@RequestParam Integer userId, HttpSession session, Model model) {
        model.addAttribute("ws", ws);
        session.setAttribute("userId", userId);
        model.addAttribute("groupList", userGroupService.findGroupIdByUserId(userId));
        return "test/index";
    }

    /**
     * 登录页面
     */
    @ApiOperation(value = "im", notes = "im页面")
    @RequestMapping("/im")
    public String im(Model model) {
        ChiGuaUser chiGuaUser=new ChiGuaUser();
        chiGuaUser.setId(1);
        chiGuaUser.setName("Thomas Bangalter");
        chiGuaUser.setPreview("I was wondering...");
        chiGuaUser.setTime("2:09 PM");
        chiGuaUser.setImg("images/thomas.jpg");
        ChiGuaUser chiGuaUser1=new ChiGuaUser();
        chiGuaUser1.setId(2);
        chiGuaUser1.setName("Dog Woofson");
        chiGuaUser1.setPreview("I was wondering...");
        chiGuaUser1.setTime("2:09 PM");
        chiGuaUser1.setImg("images/dog.png");
        ChiGuaUser chiGuaUser2=new ChiGuaUser();
        chiGuaUser2.setId(3);
        chiGuaUser2.setName("Louis CK");
        chiGuaUser2.setPreview("I was wondering...");
        chiGuaUser2.setTime("2:09 PM");
        chiGuaUser2.setImg("images/louis-ck.jpeg");

        ChiGuaUser chiGuaUser3=new ChiGuaUser();
        chiGuaUser3.setId(4);
        chiGuaUser3.setName("Bo Jackson");
        chiGuaUser3.setPreview("It’s not that bad...");
        chiGuaUser3.setTime("2:09 PM");
        chiGuaUser3.setImg("images/bo-jackson.jpg");
        List<ChiGuaUser> users = new ArrayList<>();
        users.add(chiGuaUser3);
        users.add(chiGuaUser2);
        users.add(chiGuaUser1);
        users.add(chiGuaUser);
        model.addAttribute("users", users);
        return "im";
    }
}
