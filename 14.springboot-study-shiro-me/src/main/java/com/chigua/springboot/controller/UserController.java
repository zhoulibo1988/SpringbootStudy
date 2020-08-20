package com.chigua.springboot.controller;

import com.chigua.springboot.entity.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassNameUserController
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/3 17:54
 * @Version V1.0
 **/
@RestController
public class UserController {
    @Autowired
    ObjectMapper mapper;
    /** *  
     * 
     * @param 	
     * @return com.chigua.springboot.entity.User
     * @author Mr.zhou
     * @date 2020-08-03
     */
    @RequestMapping("getuser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserName("mrbird");
        user.setBirthday(new Date());
        return  user;
    }


    /** *  
     *
     当采用树遍历的方式时，JSON被读入到JsonNode对象中，可以像操作XML DOM那样读取JSON
     * @return java.lang.String
     * @author Mr.zhou
     * @date 2020-08-03
     */
    @RequestMapping("readjsonstring")
    @ResponseBody
    public String readJsonString() {
        try {
            String json = "{\"name\":\"mrbird\",\"age\":26}";
            JsonNode node = this.mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /** *  
     *
     Java对象和JSON数据进行绑定
     * @return java.lang.String
     * @author Mr.zhou
     * @date 2020-08-04
     */
    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
            String json = "{\"name\":\"mrbird\",\"age\":26}";
            User user = mapper.readValue(json, User.class);
            String name = user.getUserName();
            int age = user.getAge();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
