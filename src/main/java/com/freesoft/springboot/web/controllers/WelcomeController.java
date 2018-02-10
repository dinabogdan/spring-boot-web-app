package com.freesoft.springboot.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freesoft.springboot.web.configuration.BasicConfiguration;
import com.freesoft.springboot.web.services.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;

	@Autowired
	private BasicConfiguration basicConfiguration;

	@RequestMapping("/welcome")
	public String welcomeMessage() {
		return welcomeService.getWelcomeMessage();
	}

	@RequestMapping("/dynamic-configuration")
	public Map<?, ?> dynamicConfiguration() {
		Map<Object, Object> map = new HashMap<>();
		map.put("message", basicConfiguration.getMessage());
		map.put("number", basicConfiguration.getNumber());
		map.put("value", basicConfiguration.isValue());
		return map;
	}
}
