package com.chigua.springboot.result;
/**
 * ProjectName: springboot-study-result
 * ClassName: com.chigua.springboot.result.RetResult
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 对结果处理的一个类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/31 - 11:23
 */

public class RetResult {
    //其中msg是你想要返回的信息，
    // code就是自定义的状态码了,
    // data是要返回的数据，
    // 这里我采用了Object类型。
    // 而且这里我写了几个重载方法，
    // 可以根据自己的需求来灵活调整

    private  Integer code;
    private String msg;
    private Object data;
    public RetResult(){
        this.code = Integer.valueOf(0);
        this.msg = "";
        this.data = null;
    }
    /**
     *返回状态码、信息、以及数据
     */
    public RetResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = "";
        this.data = null;
    }
    /**
     *只返回状态码，以及信息可以用于失败时候来使用
     */
    public RetResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    /**
     *只返回状态码和数据
     */
    public RetResult(Integer code, Object data) {
        this.code = code;
        this.msg = "";
        this.data = data;
    }
    /**
     *  操作成功的时候直接返回数据
     * @param data
     * @return
     * @author Mr.zhou
     * @date 2020-07-31
     */
    public RetResult( Object data) {
        this.code = RetCode.SUCCESS.getCode();
        this.msg = "操作成功";
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
