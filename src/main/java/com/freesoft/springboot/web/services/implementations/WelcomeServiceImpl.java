package com.freesoft.springboot.web.services.implementations;

import org.springframework.stereotype.Service;

import com.freesoft.springboot.web.services.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String getWelcomeMessage() {
		return "Hello! Here is Spring!";
	}

}
