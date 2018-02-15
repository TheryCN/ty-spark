package com.example.tysparkweb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests.
 * 
 * @author tcharass
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TySparkWebApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
	}

	/**
	 * Test /api/weather.
	 */
	@Test
	public void testWeatherStats() {
		// Given
		// When
		ResponseEntity<Double[]> response = testRestTemplate.getForEntity("/api/weather", Double[].class);
		// Then
		List<Double> values = Arrays.asList(response.getBody());
		assertThat(values.size()).isEqualTo(10);
	}

}
