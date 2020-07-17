package com.chigua.springboot;

import com.chigua.springboot.controller.config.CustomConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 开始学习Springboot 第2天 学习Spring boot 配置文件与自定义配置文件
 * @return
 * @author Mr.zhou
 * @date 2020-07-17
 */
@SpringBootApplication
@EnableConfigurationProperties({CustomConfig.class})
public class SpringbootStudyOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyOneApplication.class, args);
	}

}
