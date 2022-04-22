package com.test.testapi;

import com.test.testapi.data.DataController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApiApplication {

	public static void main(String[] args) {
		DataController.generateCustomersData(100);
		SpringApplication.run(TestApiApplication.class, args);
	}

}
