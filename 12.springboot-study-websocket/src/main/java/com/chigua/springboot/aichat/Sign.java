package com.chigua.springboot.aichat;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * ProjectName: springboot-websocket-demo
 * ClassName: com.chigua.springboot.aichat.Sign
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 签名
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/07 - 10:05
 */

public class Sign {

    public static Map<String, String> getSignature(Map<String, String> params, String CONFIG) throws IOException {
        Map<String, String> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            if (param.getValue() != null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim())
                    && !"".equals(param.getValue())) {
                baseString.append(param.getKey().trim()).append("=")
                        .append(URLEncoder.encode(param.getValue().toString(), "UTF-8")).append("&");
            }
        }
        if (baseString.length() > 0) {
            baseString.deleteCharAt(baseString.length() - 1).append("&app_key=").append(CONFIG);
        }
        try {
            String sign = MD5Utils.MD5(baseString.toString()).toUpperCase();
            sortedParams.put("sign", sign);
        } catch (Exception ex) {
            throw new IOException(ex);
        }
        return sortedParams;
    }
}
