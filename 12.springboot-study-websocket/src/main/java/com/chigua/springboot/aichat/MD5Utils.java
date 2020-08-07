package com.chigua.springboot.aichat;/**
 * ProjectName: springboot-websocket-demo
 * ClassName: com.chigua.springboot.aichat.MD5Utils
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 计算字符串的MD5
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/07 - 10:17
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassNameMD5Utils
 * @Description
 * @Author Mr.Zhou
 * @Date2020/8/7 10:17
 * @Version V1.0
 **/
public class MD5Utils {
    /**
     * 计算字符串的MD5
     * @param input 要被计算的字符串
     * @return 返回计算后的MD5
     */
    public static String MD5(String input) {
        if(input == null || input.length() == 0) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            byte[] byteArray = md5.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : byteArray) {
                // 一个byte格式化成两位的16进制，不足两位高位补零
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
