package com.ttt.cliapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CliappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliappApplication.class, args);
	}

}
