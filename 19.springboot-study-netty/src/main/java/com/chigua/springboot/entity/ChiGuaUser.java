package com.chigua.springboot.entity;/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.entity.ChiGuaUser
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户表
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 17:21
 */

public class ChiGuaUser {

    private int id;

    private String img;

    private String name;

    private String time;

    private String preview;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
