package com.chigua.springboot.controller.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassNameTestConfig :自定义配置文件
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/17 17:51
 * @Version V1.0
 **/
@Configuration
@ConfigurationProperties(prefix="test")
@PropertySource("classpath:test.properties")
@Component
public class CustomConfig {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
