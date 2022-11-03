package com.ttt.app;

import javafx.application.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class AppApplication {
	public static void main(String[] args) {
		Application.launch(AppFX.class);
	}
}
