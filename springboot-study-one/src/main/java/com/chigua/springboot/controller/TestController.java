package com.chigua.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameTestController
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/17 17:24
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/getName")
    @ResponseBody
    public String getName(){
        return "hello,my name  is zlbwww";
    }
}
