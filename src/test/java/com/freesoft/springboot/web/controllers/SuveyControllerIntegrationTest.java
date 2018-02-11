package com.freesoft.springboot.web.controllers;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

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

}
