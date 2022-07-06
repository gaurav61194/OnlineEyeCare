package com.cg.onlineeyecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OnlineEyeCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEyeCareApplication.class, args);
		System.out.println("Connect to database");
	}

}
