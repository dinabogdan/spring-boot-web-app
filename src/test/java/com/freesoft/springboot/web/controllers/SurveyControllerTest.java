package com.freesoft.springboot.web.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.freesoft.springboot.web.jpa.repositories.UserRepository;
import com.freesoft.springboot.web.services.SurveyService;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTest {
	
	@MockBean
	private SurveyService surveyService;
	
	@MockBean 
	private UserRepository userRepository;

	@Test
	public void testMethod() {
		
	}

}
