package com.freesoft.springboot.web.controllers;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.freesoft.springboot.web.Application;
import com.freesoft.springboot.web.beans.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SuveyControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Test
	public void testJsonAssert() {
		final String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		JSONAssert.assertEquals(
				"{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}",
				response.getBody(), false);
	}

	@Test
	public void test() {
		final String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println("### RESPONSE: " + response.getBody());
		assertTrue(response.getBody().contains("\"id\":\"Question1\""));
	}

	@Test
	public void addQuestion() {
		String URL = "http://localhost:" + port + "/surveys/Survey1/questions";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		Question q1 = new Question("QuestionXX", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		
		HttpEntity<Question> entity = new HttpEntity<>(q1, headers);
		ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		System.out.println("### The actual is: " + actual);
		assertTrue(actual.contains("/surveys/Survey1/questions/"));

	}

}
