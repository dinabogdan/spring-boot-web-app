package com.freesoft.springboot.web.services.implementations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.freesoft.springboot.web.services.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService{
	
	@Value("${welcome.message}")
	private String welcomeMessage;

	@Override
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

}
