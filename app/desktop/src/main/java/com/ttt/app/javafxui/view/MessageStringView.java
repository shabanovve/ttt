package com.ttt.app.javafxui.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RequiredArgsConstructor
@Component
public class MessageStringView {
    private final MainWindow mainWindow;
    public void addMessage(String message) {
        String time = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .format(ZonedDateTime.now());
        Label label = new Label(time + ": " + message);
        label.setFont(new Font("Arial", 20));
        label.setMinHeight(50);
        label.setMinWidth(100);
        Platform.runLater(() -> mainWindow.getVbox().getChildren().addAll(label));
    }
}
