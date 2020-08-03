package com.chigua.springboot.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ProjectName: springboot-study-aop
 * ClassName: com.chigua.springboot.log.Log
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 定义一个方法级别的@Log注解，用于标注需要监控的方法
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/30 - 14:50
 */

@Target(ElementType.METHOD)//注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
public @interface Log {
    String value() default "";
}
