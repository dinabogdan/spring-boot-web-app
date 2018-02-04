package com.freesoft.springboot.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freesoft.springboot.web.services.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping("/welcome")
	public String welcomeMessage() {
		return welcomeService.getWelcomeMessage();
	}
}
