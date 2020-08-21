package com.chigua.springboot.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassNameGlobalExceptionHandler
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/21 16:58
 * @Version V1.0
 **/
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    /** *
     * 无权操作重定向 403
     * @return com.chigua.springboot.result.RetResult
     * @author Mr.zhou
     * @date 2020-08-21
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorizationException() {
        return "403";
    }
}
