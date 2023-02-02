package com.babel.calculator;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = CalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {
	
	@LocalServerPort
	int randomServerPort;

	@Test
	void contextLoads() {
	}

	private ResponseEntity<Double> calculate(BigDecimal firstElement, BigDecimal secondElement, String operation)
			throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		URI uri = new URI("http://localhost:" + randomServerPort + "/api/calculate?firstElement=" + firstElement
				+ "&secondElement=" + secondElement + "&operation=" + operation);

		ResponseEntity<Double> resultado = restTemplate.getForEntity(uri, Double.class);
		return resultado;
	}

	@Test
	public void addHappyPath() throws URISyntaxException {

		ResponseEntity<Double> resultado = calculate(BigDecimal.valueOf(4), BigDecimal.valueOf(6), "add");

		Assert.assertEquals(HttpStatusCode.valueOf(200), resultado.getStatusCode());
		Assert.assertEquals(10.0d, resultado.getBody().doubleValue(), 0.001d);
	}

	@Test
	public void substracHappyPath() throws URISyntaxException {

		ResponseEntity<Double> resultado = calculate(BigDecimal.valueOf(20), BigDecimal.valueOf(5), "substrac");

		Assert.assertEquals(HttpStatusCode.valueOf(200), resultado.getStatusCode());
		Assert.assertEquals(15.0d, resultado.getBody().doubleValue(), 0.001d);
	}

	@Test
	public void multiplyHappyPath() throws URISyntaxException {

		ResponseEntity<Double> resultado = calculate(BigDecimal.valueOf(20), BigDecimal.valueOf(5), "multiply");

		Assert.assertEquals(HttpStatusCode.valueOf(200), resultado.getStatusCode());
		Assert.assertEquals(100.0d, resultado.getBody().doubleValue(), 0.001d);
	}

	@Test
	public void divideHappyPath() throws URISyntaxException {

		ResponseEntity<Double> resultado = calculate(BigDecimal.valueOf(25), BigDecimal.valueOf(5), "divide");

		Assert.assertEquals(HttpStatusCode.valueOf(200), resultado.getStatusCode());
		Assert.assertEquals(5.0d, resultado.getBody().doubleValue(), 0.001d);
	}

}
