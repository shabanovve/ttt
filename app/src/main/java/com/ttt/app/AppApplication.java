package com.ttt.app;

import com.ttt.app.config.ApiConfig;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ApiConfig.class)
@SpringBootApplication
public class AppApplication {
	public static void main(String[] args) {
		Application.launch(AppFX.class);
	}
}
