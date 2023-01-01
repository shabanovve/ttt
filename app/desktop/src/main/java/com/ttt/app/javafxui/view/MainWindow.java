package com.ttt.app.javafxui.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MainWindow {
    private final ApplicationContext context;
    private VBox vbox;

    public VBox getVbox() {
        return vbox;
    }
    public void create() {
        Stage stage = context.getBean(Stage.class);
        createVBox();
        ScrollPane pane = new ScrollPane(vbox);
        Scene scene = new Scene(pane, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("LCC ttt app");
        stage.show();
    }

    private void createVBox() {
        vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
    }
}
