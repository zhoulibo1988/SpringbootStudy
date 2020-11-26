package com.chigua.springboot.model;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.model.OnlineMessage
 *
 * @author Mr.zhou <ijiami.cn>
 * @description wbocket接消息实体
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 15:21
 */
public class OnlineMessage {
    /**
     * 消息发送者id
     */
    private String sendId;
    /**
     * 消息接受者id
     */
    private String acceptId;
    /**
     * 消息内容
     */
    private String message;

    /**
     * 头像
     */
    private String headImg;

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(String acceptId) {
        this.acceptId = acceptId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
