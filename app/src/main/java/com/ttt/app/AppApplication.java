package com.ttt.app;

import com.ttt.app.config.ChatConfig;
import com.ttt.app.config.TelegramApiConfig;
import com.ttt.app.config.TelegramLogConfig;
import com.ttt.app.view.NativeLibsLoader;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({TelegramApiConfig.class, TelegramLogConfig.class, ChatConfig.class})
@SpringBootApplication
public class AppApplication {
	public static void main(String[] args) {
		new NativeLibsLoader().load();
		Application.launch(AppFX.class);
	}
}
