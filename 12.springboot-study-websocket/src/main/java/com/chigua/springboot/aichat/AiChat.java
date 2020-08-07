package com.chigua.springboot.aichat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName: springboot-websocket-demo
 * ClassName: com.chigua.springboot.aichat.AiChat
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/07 - 10:03
 */

public class AiChat {
    public static String getAiAnswer(String msg) {
        String result = null;
        Map<String, String> tempParamS = new HashMap<>();
        Map<String, String> signMap;
        try {
            tempParamS.put("app_id", "2155421090");
            tempParamS.put("time_stamp", System.currentTimeMillis() / 1000 + "");
            tempParamS.put("nonce_str", RandomUtils.generateString(16));
            tempParamS.put("session", RandomUtils.getNotSimple(6) + "");
            tempParamS.put("question", msg);
            tempParamS.put("sign", "");
            signMap = Sign.getSignature(tempParamS, "YwnCI9YIGmJV93SX");
            String rel = HttpUtils.postHttps("https://api.ai.qq.com/fcgi-bin/nlp/nlp_textchat",signMap);
                JSONObject obj = JSON.parseObject(rel);
                if (0 == obj.getInteger("ret")) {
                    TencentAIAnswer objRet = JSON.parseObject(obj.getString("data"), TencentAIAnswer.class);
                    result = objRet.getAnswer();
                }
                if (obj.getInteger("ret") < 0) {
                    result = "网络异常~";
                }
                if (obj.getInteger("ret") > 0) {
                    result = "我脑子被麻花藤玩坏了哦，快找我爸爸韩梅梅帮我看看吧~";
                }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
     String msg=   getAiAnswer("找不到女朋友怎么办");
     System.out.println(msg);
    }
}
