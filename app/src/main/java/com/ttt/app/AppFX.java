package com.ttt.app;

import com.ttt.app.telegram.TelegramService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class AppFX extends Application {
    private ConfigurableApplicationContext applicationContext;
    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(AppApplication.class).run();
    }
    @Override
    public void start(Stage stage) {
        applicationContext.getBeanFactory().registerSingleton("stage", stage);
        applicationContext.publishEvent(new StageReadyEvent(stage));
        applicationContext.getBean(TelegramService.class).start();
    }
    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }
    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
    }
}
