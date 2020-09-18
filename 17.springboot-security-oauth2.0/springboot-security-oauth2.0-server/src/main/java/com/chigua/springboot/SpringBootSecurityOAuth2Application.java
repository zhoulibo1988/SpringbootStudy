package com.chigua.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Boot 授权服务
 * @return
 * @author Mr.zhou
 * @date 2020-07-17
 */
@SpringBootApplication
//开启缓存
@EnableCaching
public class SpringBootSecurityOAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityOAuth2Application.class, args);
	}

}
