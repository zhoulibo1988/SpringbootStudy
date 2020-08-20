package com.chigua.springboot.utils;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassNameIPUtils
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/30 15:25
 * @Version V1.0
 **/
public class IPUtils {
    /**
     * 获取IP地址
     *
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }


    public  static void sss(final  String name){
        System.out.println(name);
    }

    public static void main(String[] args) {
        send();
    }

    public static void send() {
        final Map<String, Object> postMap = new HashMap<String, Object>();
//		    	String txt="{\\\"bindTopic\\\":\\\"topic_1558762487588\\\",\\\"lableName\\\":\\\"APP启动分析\\\",\\\"topicName\\\":\\\"topic_on_1558661313787\\\",\\\"category\\\":\\\"2\\\",\\\"events\\\":[{\\\"day_use_time\\\":\\\"0.0\\\",\\\"lastTime\\\":\\\"1558837587\\\",\\\"country\\\":\\\"CN\\\",\\\"first_startup_time\\\":\\\"1558696333\\\",\\\"urlTime\\\":\\\"[26/May/2019:10:26:27 +0800]\\\",\\\"cpuModel\\\":\\\" Qualcomm Technologies, Inc MSM8998\\\",\\\"wifiStong\\\":\\\"-58\\\",\\\"deviceId\\\":\\\"5688EB52F20E64C7\\\",\\\"phoneModel\\\":\\\"PH-1\\\",\\\"province\\\":\\\"未知位置\\\",\\\"hasBlackListApp\\\":false,\\\"cerIdentifierMD5\\\":\\\"8ddb342f2da5408402d7568af21e29f9\\\",\\\"cpuUseRatio\\\":\\\"90\\\",\\\"appKey\\\":\\\"9f96b944e2a1cdf2a26c0401\\\",\\\"IpaVersion\\\":\\\"1.0\\\",\\\"wifiBssid\\\":\\\"02:00:00:00:00:00\\\",\\\"deviceScreenStr\\\":\\\"1312*2560\\\",\\\"day_startup_count\\\":\\\"1.0\\\",\\\"kernelstatus\\\":\\\"内核存在风险\\\",\\\"fieldUrl\\\":\\\"/publicLog/appStartUp\\\",\\\"exeFileMD5\\\":\\\"0b1fa20939a971497e5897ff514c3d5f\\\",\\\"appPackageName\\\":\\\"com.idata.demo\\\",\\\"sdkVersion\\\":\\\"1.9.4\\\",\\\"cerTeamName\\\":\\\"EMAILADDRESS=android@android.com, CN=Android, OU=Android, O=Android, L=Mountain View, ST=California, C=US\\\",\\\"city\\\":\\\"未知位置\\\",\\\"battery\\\":\\\"58\\\",\\\"mac\\\":\\\"10:CD:B6:13:72:64\\\",\\\"memoryUseRatio\\\":\\\"48\\\",\\\"phoneOS\\\":\\\"9\\\",\\\"currentIPAddress\\\":\\\"172.10.17.189\\\",\\\"isStartSuccess\\\":true,\\\"networkType\\\":\\\"wifi\\\",\\\"isSimulator\\\":true,\\\"IpaVersionCode\\\":\\\"1\\\",\\\"factory\\\":\\\"essential\\\",\\\"phoneType\\\":\\\"1\\\",\\\"istamper\\\":false,\\\"startAppTime\\\":\\\"1558908863694\\\",\\\"appName\\\":\\\"官网Demo\\\",\\\"libcstatus\\\":\\\"LIBC没有被HOOK\\\",\\\"wifiStatus\\\":\\\"enabled\\\",\\\"isFirstApp\\\":false,\\\"isprison\\\":true,\\\"localTime\\\":\\\"1558908863813\\\",\\\"cpuStruct\\\":\\\"arm7\\\",\\\"last_startup_time\\\":\\\"1558908863\\\",\\\"interfaceKey\\\":\\\"AAA\\\",\\\"hasFakeLocation\\\":false,\\\"time\\\":\\\"2019-05-26 10:26:27\\\"}]}";
//		    	String baseString=Base64Util.getSecretKey(txt);
//		    	postMap.put("upload","tWcNeqS8Z/PffxopPrN4zBQWMq6OCkFzhWB8NZwxnjivdWTeqqPoQvDQ+oIGmnkzjRk+s+N/7lF5P7D9eZwk+twX64gkgTrbFrBQcVVEfdizLsESZpPIt1enWVNq/CsLdWQuJANDSzQK38iOkoihWiUZ4bTFKFems9mM2pgxEYlx5OTJq5rdG7TpV2o6PyJnlTxxFDoxWcOM+G+In2QDM9e1XoxXzteAlCeMMOaNBfzZw/XSfqapvUl0VpT3QKNuObMbz5S+YWIBu+7iLslKf/oFs1JutZW4JGyoBpke9yHlDCN9CXwvF7HFvZtQkqEc/3rHCXPNjztLHAK9ZPQgFrh8/8RX4KhRGAPeFnb5N9V2u6mlKWjMLb3JJh1NJnml5qZxOLtngZcJJFfynQsGYzeXaNZlyp5mbBWqw4mWkbMvTzGXV1xa36U5dv/TVjnBvP9gRiUDEYLSbwF+DF9XMW1iepF/gdIdh7vUE6jYho4F5ulKclxpDWSjj5Pkyu8T4xXHTy31a0PxsGKtJrzFyBBF8Nen+lEMv0bnx2lzuCGRd2XQEtrw8t/hTwxDUot5T+OHfJwWYr/W5Rn/tuQA75K6xU4O/MoTwAdWmytHK360a7LgDJoHWQ4y1/Gxwu4KatCSUYTKVSsEayqTEXMGQ2KAqfoGP5vOZHLLHivKiIOICdEPLtvkvXwAZh/4X727fHl6e3QycQVvcGpXD0uMB8fCLkilruStVrc0iQGsC3e2GqS6ZwljhqDO/lA2XrlcATGawGYObrg2kC1Cqkus7ywhhtn77iRIJSmru13gSEZMR+K/8U51HR7QfEbJN17fU5SU/Vb3I7WQyzijbyA4l9Hlsuz2wQkHrvYVSUaHYTx/z5Xz0tPx12ufBdSStjMac825XbfhQ2VF8jFFTJqr2NsFouWLboKz/LOzA8U0LggblLCKObH9b1x0iLVDNTJzOCcPlN/Rb7QvsVCkEvOMa5sVcCz1pPdN/4otltdeUpoOZtBKK/RDsi/OeaqkkbFkSvLxmALl+a9j5vixap7zA149sFQiKx7NdnofR6izbwk5dgCTvgaarWKDW1PyPDazmz5CjBkGGFD1mffz8j5vq0dLrE4o+6wpyUn3IvSKjMVuNeIMAU/2vkXkR1yTxWrk0X2g174njN0nE/1Uoce+W8FD5TBbJhj+2B2LgcjlrIsXM9vXlWbfhtn3n33p9IlXTp5o+3Z0IJ5du8noqzub7lvIgftTtaY4d3QfUwKIU739RF7sdndd/g==");
//                postMap.put("upload","wQEKU9u5mwHpohQZRkwzpcxSHowcbv%2FMRzrdSXjdaAHkEEqwV7AXI3mEAYokuP%2BpDmv4yIwGMVia%0AocKNpyqHKSn85YgNRvf38Se%2Bs3K3qRUDka2PhSXyW%2BOuoigU5ES5nsSwBpQmySsWkrDA%2FMGc0a%2Fv%0ACZ8ujk6I6qHEcALOCUj0dtwA1Z3uCiWSnAu2RexSSvNAznDpaIfzsM0G7TbuED%2BabteoP0HWdoA0%0AyoRsXM7OgJN9e0jcI0IYt2mbz1d3sIhtXqqbINvwALsMUFeVqPmiHGXu95cQfnuce3NOFLLDvvmU%0AB8%2FeSGno3bqcnNIPiObfaguLrJhHmiTTBrCBNj6i0kpGWGk63MrBScxCRhPk2ycffoDglAG%2BABz3%0AtkpHfesqsuqQ86sEnmMS5HmbD%2F3jjFhpWBDdoPuhtI9mjOGCavHukR39tples9Wy0LQQSYOJzX7c%0AOGkp9u4yK%2FGM8%2BKm9M2RC9VaCl04CIKEvQvYs%2B2R86OGBcXZCoHAqZP5%0A");
        String decode = URLDecoder.decode("wQEKU9u5mwHpohQZRkwzpcxSHowcbv%2FMRzrdSXjdaAHkEEqwV7AXI3mEAYokuP%2BpDmv4yIwGMVia%0AocKNpyqHKSn85YgNRvf38Se%2Bs3K3qRUDka2PhSXyW%2BOuoigU5ES5nsSwBpQmySsWkrDA%2FMGc0a%2Fv%0ACZ8ujk6I6qHEcALOCUj0dtwA1Z3uCiWSnAu2RexSSvNAznDpaIfzsM0G7TbuED%2BabteoP0HWdoA0%0AyoRsXM7OgJN9e0jcI0IYt2mbz1d3sIhtXqqbINvwALsMUFeVqPmiHGXu95cQfnuce3NOFLLDvvmU%0AB8%2FeSGno3bqcnNIPiObfaguLrJhHmiTTBrCBNj6i0kpGWGk63MrBScxCRhPk2ycffoDglAG%2BABz3%0AtkpHfesqsuqQ86sEnmMS5HmbD%2F3jjFhpWBDdoPuhtI9mjOGCavHukR39tples9Wy0LQQSYOJzX7c%0AOGkp9u4yK%2FGM8%2BKm9M2RC9VaCl04CIKEvQvYs%2B2R86OGBcXZCoHAqZP5%0A");
        postMap.put("upload", decode);
        System.out.println("解码:" + decode);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    String r = HttpUtil.httpPost("http://172.10.4.31:8080/publicLog/bydApi", postMap);
                    System.out.println(r);
                }
            }
        }).start();
    }
}
