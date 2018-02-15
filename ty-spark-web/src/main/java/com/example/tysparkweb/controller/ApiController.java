package com.example.tysparkweb.controller;

import java.util.List;

import org.apache.spark.sql.SparkSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tysparkshared.task.WeatherTask;

/**
 * API controller.
 * 
 * @author tcharass
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	private SparkSession sparkSession;

	private WeatherTask weatherTask;

	public ApiController(SparkSession sparkSession, WeatherTask weatherTask) {
		this.weatherTask = weatherTask;
		this.sparkSession = sparkSession;
	}

	@RequestMapping("/weather")
	public List<Double> weatherStats() {
		return weatherTask.getMaxTemperatures(sparkSession);
	}
}
