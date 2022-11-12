package com.ttt.app.telegram.handler;

import com.ttt.app.view.event.MessageEvent;
import javafx.application.Platform;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResultHandler implements Client.ResultHandler{
    private final ApplicationContext context;
    @Override
    public void onResult(TdApi.Object object) {
        Platform.runLater(() -> context.publishEvent(new MessageEvent("onResult")));
    }
}
