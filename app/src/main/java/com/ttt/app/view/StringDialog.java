package com.ttt.app.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class StringDialog {
    public static CountDownLatch createAndGetLatch(
            String title, AtomicReference<String> result, boolean isPassword
    ) {
        CountDownLatch dialogLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            do {
                TextInputDialog dialog = new TextInputDialog();
                if (isPassword) {
                    maskPassword(dialog);
                }
                dialog.setTitle(title);
                dialog.setHeaderText(null);
                dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
                dialog.showAndWait().ifPresent(result::set);
            } while (result.get() == null || result.get().isEmpty());
            dialogLatch.countDown();
        });
        return dialogLatch;
    }

    private static void maskPassword(TextInputDialog dialog) {
        PasswordField passwordField = new PasswordField();
        HBox content = new HBox();
        content.setAlignment(Pos.CENTER_LEFT);
        content.setSpacing(10);
        content.getChildren().addAll(passwordField);
        dialog.getDialogPane().setContent(content);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                return passwordField.getText();
            }
            return null;
        });
    }
}
