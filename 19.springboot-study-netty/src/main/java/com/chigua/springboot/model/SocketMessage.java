package com.chigua.springboot.model;
/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.model.SocketMessage
 *
 * @author Mr.zhou <ijiami.cn>
 * @description socket接消息实体
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 14:54
 */

public class SocketMessage {
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息发送者id
     */
    private Integer userId;
    /**
     * 消息接受者id或群聊id
     */
    private Integer chatId;
    /**
     * 消息内容
     */
    private String message;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
