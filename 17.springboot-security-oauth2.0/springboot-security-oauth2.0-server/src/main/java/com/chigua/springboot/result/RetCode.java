package com.chigua.springboot.result;

/**
 * ProjectName: springboot-study-result
 * ClassName: com.chigua.springboot.result.RetCode
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 状态码
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/31 - 11:19
 */
public enum RetCode {
    //成功
    SUCCESS(200),

    //失败
    FAIL(400),

    //错误
    FALSE(404),

    //内部错误
    ERROR(500);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private RetCode(Integer code){
        this.code=code;
    }
}
