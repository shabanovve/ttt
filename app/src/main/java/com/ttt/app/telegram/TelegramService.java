package com.ttt.app.telegram;

import com.ttt.app.telegram.handler.ExceptionHandler;
import com.ttt.app.telegram.handler.ResultHandler;
import com.ttt.app.view.MessageStringView;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class TelegramService {
    private final ResultHandler resultHandler;
    private final ExceptionHandler exceptionHandler;
    private final MessageStringView messageStringView;
    public void start() {
        String message = "Connect to telegram";
        log.info(message);
        messageStringView.addMessage(message);
        Client.create(resultHandler, exceptionHandler, exceptionHandler);
    }
}
