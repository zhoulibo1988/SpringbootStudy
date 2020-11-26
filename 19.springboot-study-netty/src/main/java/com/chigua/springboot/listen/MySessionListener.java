package com.chigua.springboot.listen;

import com.chigua.springboot.netty.ImWebSocketHandler;
import io.netty.channel.ChannelId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

/**
 * ProjectName: netty-websocket
 * ClassName: com.chigua.springboot.listen.MySessionListener
 *
 * @author Mr.zhou <ijiami.cn>
 * @description session超时, 移除 websocket对应的channel（客户端断开连接释放资源）
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/11/26 - 15:16
 */
public class MySessionListener implements HttpSessionListener {
    private final Logger logger = LoggerFactory.getLogger(MySessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("sessionCreated sessionId={}", httpSessionEvent.getSession().getId());
        MySessionContext.AddSession(httpSessionEvent.getSession());
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        Integer userId = session.getAttribute("userId") == null ? null : Integer.parseInt(session.getAttribute("userId").toString());
        //销毁时重websocket channel中移除
        if (userId != null) {
            ChannelId channelId = ImWebSocketHandler.userMap.get(userId);
            if (channelId != null) {
                //移除了私聊的channel对象, 群聊的还未移除
                ImWebSocketHandler.userMap.remove(userId);
                ImWebSocketHandler.channelGroup.remove(channelId);
                logger.info("session timeout,remove channel, userId={}", userId);
            }

        }
        MySessionContext.DelSession(session);
        logger.info("session destroyed  .... ");
    }
    public static class MySessionContext {

        private static HashMap mymap = new HashMap();

        public static synchronized void AddSession(HttpSession session) {
            if (session != null) {
                mymap.put(session.getId(), session);
            }
        }

        public static synchronized void DelSession(HttpSession session) {
            if (session != null) {
                mymap.remove(session.getId());
            }
        }

        public static synchronized HttpSession getSession(String session_id) {
            if (session_id == null) {
                return null;
            }
            return (HttpSession) mymap.get(session_id);
        }
    }
}
