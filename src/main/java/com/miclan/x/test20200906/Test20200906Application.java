package com.miclan.x.test20200906;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Test20200906Application {

	public static void main(String[] args) {
		SpringApplication.run(Test20200906Application.class, args);
	}

}
