package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.PhoneNumber;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class GetPhoneNumberHandler implements ApplicationListener<GetPhoneNumberEvent> {
    private final ConfigurableApplicationContext context;
    @Override
    public void onApplicationEvent(GetPhoneNumberEvent event) {
        CountDownLatch latch = event.getLatch();
        AtomicReference<String> result = new AtomicReference<>();
        Platform.runLater(() -> {
            do {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Enter phone number");
                dialog.setHeaderText(null);
                dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
                dialog.showAndWait().ifPresent(result::set);
            } while (result.get() == null || result.get().isEmpty());
            context.getBeanFactory()
                    .registerSingleton(
                            "phoneNumber",
                            new PhoneNumber(result.get())
                    );
            latch.countDown();
        });
    }
}
