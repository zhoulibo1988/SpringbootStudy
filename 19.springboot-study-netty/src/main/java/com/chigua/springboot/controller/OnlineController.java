package com.chigua.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.controller.ChiGuaImController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 吃瓜在线咨询页面
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 15:26
 */
@Controller
public class OnlineController {

    @Value("${netty.ws}")
    private String ws;

    /**
     * 客服界面
     */
    @GetMapping(value = {"/index", "/customer","/"})
    public String index(Model model) {
        model.addAttribute("ws", ws);
        return "customer";
    }


    /**
     * 游客页面
     */
    @GetMapping("/tourist")
    public String tourist(Model model) {
        model.addAttribute("ws", ws);
        return "tourist";
    }

}
