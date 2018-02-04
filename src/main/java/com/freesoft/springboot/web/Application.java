package com.freesoft.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.freesoft.springboot.web")
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext appCtx = SpringApplication.run(Application.class, args);
	}

}
