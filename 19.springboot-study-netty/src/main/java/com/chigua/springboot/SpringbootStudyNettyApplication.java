package com.chigua.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Boot +netty 实现在线客户功能
 * @return
 * @author Mr.zhou
 * @date 2020-07-17
 */
@SpringBootApplication
//开启缓存
@EnableCaching
public class SpringbootStudyNettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyNettyApplication.class, args);
	}

}
