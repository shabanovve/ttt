package com.ttt.app;

import com.ttt.app.javafxui.AppFX;
import com.ttt.app.telegram.config.ChatConfig;
import com.ttt.app.telegram.config.TelegramApiConfig;
import com.ttt.app.telegram.config.TelegramLogConfig;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({TelegramApiConfig.class, TelegramLogConfig.class, ChatConfig.class})
@SpringBootApplication
public class AppApplication {
	public static void main(String[] args) {
		Application.launch(AppFX.class);
	}
}
