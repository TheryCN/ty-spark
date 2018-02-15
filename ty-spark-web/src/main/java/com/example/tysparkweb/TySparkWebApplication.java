package com.example.tysparkweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.tysparkweb.controller.ApiController;

import lombok.extern.slf4j.Slf4j;

/**
 * Spark web app.
 * 
 * @author tcharass
 *
 */
@SpringBootApplication
@Slf4j
@ComponentScan({ "com.example.*" })
public class TySparkWebApplication implements CommandLineRunner {

	@Autowired
	private ApiController apiController;

	public static void main(String[] args) {
		SpringApplication.run(TySparkWebApplication.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		log.info(apiController.weatherStats().toString());
	}
}
