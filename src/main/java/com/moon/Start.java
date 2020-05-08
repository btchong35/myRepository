package com.moon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import tk.mybatis.spring.annotation.MapperScan;

@EnableWebSocket
@MapperScan(basePackages = "com.moon.dao")
@SpringBootApplication
@ServletComponentScan(basePackages = "com.moon.filter")
public class Start {
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}
}
