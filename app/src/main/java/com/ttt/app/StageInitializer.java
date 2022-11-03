package com.ttt.app;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<AppFX.StageReadyEvent> {
    @Override
    public void onApplicationEvent(AppFX.StageReadyEvent event) {
        Stage stage = event.getStage();
        BorderPane outerRoot = new BorderPane();
        Scene scene = new Scene(outerRoot, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("LCC ttt app");
        stage.show();
    }
}