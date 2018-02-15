package com.example.tysparkweb;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Spark config.
 * 
 * @author tcharass
 *
 */
@Component
public class SparkConfig {

	private String app;

	private String master;

	private String jarLocation;

	public SparkConfig(@Value("${spark.app}") String app, @Value("${spark.master}") String master,
			@Value("${spark.jar.location}") String jarLocation) {
		this.app = app;
		this.master = master;
		this.jarLocation = jarLocation;
	}

	/**
	 * Creates spark session.
	 * 
	 * @return {@link SparkSession}
	 */
	@Bean
	public SparkSession sparkSession() {
		return SparkSession.builder().appName(app).master(master).config("spark.jars", jarLocation).getOrCreate();
	}

}
