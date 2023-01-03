package com.ttt.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class CliApplication {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = run(CliApplication.class, args)) {
		}
	}

}
