package com.chigua.springboot.entity;/**
 * ProjectName: springboot-study-websocket
 * ClassName: com.chigua.springboot.entity.ChatMessage
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/06 - 11:46
 */

/**
 * @ClassNameChatMessage
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/6 11:46
 * @Version V1.0
 **/
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
