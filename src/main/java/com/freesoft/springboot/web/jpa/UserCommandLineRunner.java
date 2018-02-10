package com.freesoft.springboot.web.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("UserCommandLinerRuner");
		
	}

	
}
