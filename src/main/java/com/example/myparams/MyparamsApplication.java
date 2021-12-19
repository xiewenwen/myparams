package com.example.myparams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyparamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyparamsApplication.class, args);
	}

}
