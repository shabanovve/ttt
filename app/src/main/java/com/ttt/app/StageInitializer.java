package com.ttt.app;

import com.ttt.app.view.MainWindow;
import com.ttt.app.view.MessageStringView;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StageInitializer implements ApplicationListener<AppFX.StageReadyEvent> {
    private final MainWindow mainWindow;
    private final MessageStringView  messageStringView;
    @Override
    public void onApplicationEvent(AppFX.StageReadyEvent event) {
        mainWindow.create();
        messageStringView.addMessage("Starting application");
    }

}