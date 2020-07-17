package com.chigua.springboot.controller;

import com.chigua.springboot.controller.config.CustomConfig;
import com.chigua.springboot.controller.config.OfficialConfing;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @Autowired
    private CustomConfig testConfig;
    @Autowired
    private OfficialConfing officialConfing;

    @RequestMapping("/getName")
    @ResponseBody
    public String getName(){
        return "hello,my name  is "+testConfig.getName();
    }

    @RequestMapping("/getOfficial")
    @ResponseBody
    public String getOfficial(){
        return "hello,my name  is "+officialConfing.getOfficial();
    }

}
