package com.moon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.moon.webSocket.MyHandshakeInterceptor;
import com.moon.webSocket.MyWebSocketHandler;

@Configuration
public class MyWebSocketConfig implements WebSocketConfigurer {

	@Bean
	public MyWebSocketHandler myWebSocketHandler() {
		return new MyWebSocketHandler();
	}

	@Bean
	public MyHandshakeInterceptor myHandshakeInterceptor() {
		return new MyHandshakeInterceptor();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myWebSocketHandler(), "/ws").addInterceptors(myHandshakeInterceptor())
				.setAllowedOrigins("*");
	}

}
