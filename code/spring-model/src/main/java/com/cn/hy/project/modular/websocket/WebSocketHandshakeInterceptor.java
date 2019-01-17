package com.cn.hy.project.modular.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * <p>Title: WebSocketHandshakeInterceptor </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午4:50:07
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
	
	/**
	 * beforeHandshake
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse paramServerHttpResponse,
			WebSocketHandler paramWebSocketHandler, Map<String, Object> paramMap) throws Exception {
		return true;
	}

	/**
	 * afterHandshake
	 */
	@Override
	public void afterHandshake(ServerHttpRequest paramServerHttpRequest, ServerHttpResponse paramServerHttpResponse,
			WebSocketHandler paramWebSocketHandler, Exception paramException) {
		// TODO Auto-generated method stub

	}

}
