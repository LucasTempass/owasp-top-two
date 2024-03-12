package com.unisinos.owasptoptwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class OwaspTopTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwaspTopTwoApplication.class, args);
	}

}
