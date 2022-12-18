package com.ttt.app.telegram;

import com.ttt.app.telegram.event.MessageEvent;
import com.ttt.app.telegram.handler.DefaultExceptionHandler;
import com.ttt.app.telegram.handler.ResultHandler;
import com.ttt.app.telegram.handler.UpdateExceptionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class TelegramService {
    private final ResultHandler resultHandler;
    private final UpdateExceptionHandler updateExceptionHandler;
    private final DefaultExceptionHandler  defaultExceptionHandler;
    private final ConfigurableApplicationContext context;

    public void start() {
        String message = "Connecting to telegram";
        log.info(message);
        context.publishEvent(new MessageEvent(message));
        Client client = Client.create(resultHandler, updateExceptionHandler, defaultExceptionHandler);
        context.getBeanFactory().registerSingleton("client", client);
    }
}
