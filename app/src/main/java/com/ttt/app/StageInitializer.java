package com.ttt.app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<AppFX.StageReadyEvent> {
    @Override
    public void onApplicationEvent(AppFX.StageReadyEvent event) {
        Stage stage = event.getStage();
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        for (int i = 0; i < 100; i++) {
            Label label = new Label("Start application.");
            label.setFont(new Font("Arial", 20));
            label.setMinHeight(50);
            label.setMinWidth(100);
            vbox.getChildren().addAll(label);
        }
        ScrollPane pane = new ScrollPane(vbox);
        Scene scene = new Scene(pane, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("LCC ttt app");
        stage.show();
    }

}