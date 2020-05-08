package com.moon.webSocket;

import java.util.Map;

import com.moon.model.SysUser;
import com.moon.utils.BaseController;
import com.moon.utils.JwtUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;

public class MyHandshakeInterceptor extends BaseController implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		HttpServletRequest req=((ServletServerHttpRequest) request).getServletRequest();
		String pid=req.getParameter("pid");
		String token=super.getCookieVal(req, "token");
		SysUser user= JwtUtils.getObject(token, SysUser.class);
		attributes.put("user", user);
		attributes.put("pid", pid);
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}


}
