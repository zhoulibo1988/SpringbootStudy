package com.chigua.springboot.exception;

import com.chigua.springboot.result.RetCode;
import com.chigua.springboot.result.RetResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: springboot-study-exception
 * ClassName: com.chigua.springboot.exception.ExceptionController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description异常处理
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/31 - 14:31
 */
@ControllerAdvice
@ResponseBody
public class ExceptionController {

    private String NullPointerExceptionStr="空指针异常";
    private String ArrayIndexOutOfBoundsStr="数组越界异常";
    private String ClassCastExceptionStr="类型转换异常";
    private int ERROR_CODE = RetCode.ERROR.getCode();

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    //空指针异常

    @ExceptionHandler(NullPointerException.class)
    public RetResult nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(ERROR_CODE, new Exception(NullPointerExceptionStr));
    }

    //类型转换异常

    @ExceptionHandler(ClassCastException.class)
    public RetResult classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(ERROR_CODE,  new Exception(ClassCastExceptionStr));
    }


    //数组越界异常

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public RetResult ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        return resultFormat(ERROR_CODE, new Exception(ArrayIndexOutOfBoundsStr));
    }

    //其他错误

    @ExceptionHandler({Exception.class})
    public RetResult exception(Exception ex) {
        ex.getMessage();
        return resultFormat(ERROR_CODE, new Exception("其他错误"));
    }

    private <T extends Throwable> RetResult resultFormat(Integer code, T ex) {
        ex.printStackTrace();
        return new RetResult(code,ex.getMessage());
    }

}
