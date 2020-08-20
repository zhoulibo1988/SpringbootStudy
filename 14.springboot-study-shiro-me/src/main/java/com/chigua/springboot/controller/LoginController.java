package com.chigua.springboot.controller;


import com.chigua.springboot.entity.SysUser;
import com.chigua.springboot.result.RetCode;
import com.chigua.springboot.result.RetResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.controller.LoginController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 登录业务处理
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/11 - 10:56
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    @ResponseBody
    public RetResult login(String username, String password,Boolean rememberMe){

        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new  RetResult();
        } catch (UnknownAccountException e) {
            RetResult retResult=  new  RetResult();
            retResult.setCode(RetCode.FAIL.getCode());
            retResult.setMsg( e.getMessage());
            return retResult;
        } catch (IncorrectCredentialsException e) {
            RetResult retResult=  new  RetResult();
            retResult.setCode(RetCode.FAIL.getCode());
            retResult.setMsg( e.getMessage());
            return retResult;
        } catch (LockedAccountException e) {
            RetResult retResult=  new  RetResult();
            retResult.setCode(RetCode.FAIL.getCode());
            retResult.setMsg( e.getMessage());
            return retResult;
        } catch (AuthenticationException e) {
            RetResult retResult=  new  RetResult();
            retResult.setCode(RetCode.FAIL.getCode());
            retResult.setMsg( e.getMessage());
            return retResult;
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
