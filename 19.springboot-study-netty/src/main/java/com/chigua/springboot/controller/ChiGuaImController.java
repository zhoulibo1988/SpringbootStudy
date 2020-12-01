package com.chigua.springboot.controller;

import com.chigua.springboot.entity.ChiGuaUser;
import com.chigua.springboot.service.ChiGuaUserService;
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
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    ChiGuaUserService chiGuaUserService;

    /**
     * 登录页面
     */
    @ApiOperation(value = "login", notes = "登录页面")
    @RequestMapping("/login")
    public String login() {
        return "login";
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
    @ApiOperation(value = "im.do", notes = "im页面")
    @RequestMapping("/im.do")
    public String im(@RequestParam String logemail, String logpass, HttpSession session, Model model) {
        //简单登录
        ChiGuaUser chiGuaUser = new ChiGuaUser();
        chiGuaUser.setEmil(logemail);
        chiGuaUser.setPssword(logpass);
        chiGuaUser = chiGuaUserService.login(chiGuaUser);
        if (chiGuaUser != null) {
            System.out.println(logemail);
            System.out.println(logpass);
            session.setAttribute("userId", chiGuaUser.getId());
            //获取其他用户列表
            List<ChiGuaUser> users = chiGuaUserService.getChiguaUserList(chiGuaUser);
            model.addAttribute("users", users);
            model.addAttribute("ws", ws);
            return "im";
        } else {
            return "errer";
        }
    }


    @ApiOperation(value = "register.do", notes = "注册")
    @RequestMapping("/register.do")
    public String register(@RequestParam String logemail,@RequestParam String logpass, @RequestParam String logname) {
        //简单登录
        ChiGuaUser chiGuaUser = new ChiGuaUser();
        chiGuaUser.setEmil(logemail);
        chiGuaUser.setPssword(logpass);
        chiGuaUser.setName(logname);
        chiGuaUser.setIsDel(0);
        chiGuaUser.setCreateTime(new Date());
        chiGuaUser.setImg("images/"+getImg());
        chiGuaUserService.addUser(chiGuaUser);
        return "login";
    }

    private static  String getImg(){
        String [] ims={"bo-jackson.jpg","michael-jordan.jpg","own_head.jpg","dog.png","drake.jpg","louis-ck.jpeg","thomas.jpg"};
        Random random=new Random();
        int in=random.nextInt(ims.length);
        return ims[in];

    }
}
