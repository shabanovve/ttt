package com.ttt.app.view;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class StringDialog {
    public static CountDownLatch createAndGetLatch(String title, AtomicReference<String> result) {
        CountDownLatch dialogLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            do {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle(title);
                dialog.setHeaderText(null);
                dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
                dialog.showAndWait().ifPresent(result::set);
            } while (result.get() == null || result.get().isEmpty());
            dialogLatch.countDown();
        });
        return dialogLatch;
    }
}
