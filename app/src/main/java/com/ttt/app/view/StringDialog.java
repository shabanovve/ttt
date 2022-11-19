package com.ttt.app.view;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.concurrent.atomic.AtomicReference;

public class StringDialog {
    public static void create(String title, AtomicReference<String> result) {
        Platform.runLater(() -> {
            do {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle(title);
                dialog.setHeaderText(null);
                dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
                dialog.showAndWait().ifPresent(result::set);
            } while (result.get() == null || result.get().isEmpty());
        });
    }
}
