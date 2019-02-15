/**
 * 
 */
package com.cn.hy.project.modular.schedule;

import com.cn.hy.project.modular.service.IUserService;
import com.cn.hy.project.modular.util.Constants;
import com.cn.hy.project.modular.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: ScheduleTask </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午6:18:26
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class ScheduleTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);

	@Autowired
	private IUserService iUserService;

	public void websocketTask() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//获取WebSocketServer对象的映射。
		ConcurrentHashMap<String, WebSocketServer> map = WebSocketServer.getWebSocketMap();
		if (map.size() != 0) {
			String messageString = Constants.COMM_GSON.toJson(iUserService.getAllUsers());
			for (Map.Entry<String, WebSocketServer> entry : map.entrySet()) {
				WebSocketServer webSocketServer = entry.getValue();
				try {
					//向客户端推送消息
					webSocketServer.getSession().getBasicRemote().sendText(messageString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("WebSocket未连接");
		}
	}

}
