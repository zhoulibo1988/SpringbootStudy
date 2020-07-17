package com.chigua.springboot.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassNameOfficialConfing :获取官方配置文件application.properties中 自定义文件
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/17 18:06
 * @Version V1.0
 **/
@Component
public class OfficialConfing {

    @Value("${official.name}")
    private String official;

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }
}
