package com.chigua.springboot.aichat;

import java.io.Serializable;

/**
 * ProjectName: springboot-websocket-demo
 * ClassName: com.chigua.springboot.aichat.TencentAIAnswer
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 收到的腾讯智能聊天消息
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/07 - 09:56
 */
public class TencentAIAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ret;
    private String msg;
    private String session;
    private String answer;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
