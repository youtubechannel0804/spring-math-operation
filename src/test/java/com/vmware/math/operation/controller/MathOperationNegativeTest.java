package com.vmware.math.operation.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import java.net.URI;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmware.math.operation.model.MathVariable;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MathOperationNegativeTest {

	private static final String VALID_PASSWORD = "admin1234";

	private static final String USERNAME = "admin";

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@Autowired
	private ObjectMapper objectMapper;

	@LocalServerPort
	int randomServerPort;

	@Autowired
	private TestRestTemplate template;
	HttpEntity<String> request;
	String baseUrl;

	@Before
	public void setup() throws JsonProcessingException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		baseUrl = "http://localhost:" + randomServerPort + "/api";
		MathVariable mathVariable = new MathVariable("1e00", "5w0");
		String jsonRequest = objectMapper.writeValueAsString(mathVariable);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		request = new HttpEntity<String>(jsonRequest.toString(), headers);
	}

	@org.junit.Test
	public void testAddAPI() throws Exception {

		URI uri = new URI(baseUrl + "/add");
		ResponseEntity<String> response = template.withBasicAuth(USERNAME, VALID_PASSWORD).postForEntity(uri, request,
				String.class);
		verifyResponse(response);
	}

	@org.junit.Test
	public void testDiffAPI() throws Exception {

		URI uri = new URI(baseUrl + "/diff");
		ResponseEntity<String> response = template.withBasicAuth(USERNAME, VALID_PASSWORD).postForEntity(uri, request,
				String.class);

		verifyResponse(response);
	}

	public void verifyResponse(ResponseEntity<String> response) {
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
}
