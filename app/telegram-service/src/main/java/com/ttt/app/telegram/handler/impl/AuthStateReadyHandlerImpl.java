package com.ttt.app.telegram.handler.impl;

import com.ttt.app.telegram.config.ChatConfig;
import com.ttt.app.telegram.event.AuthStateReadyEvent;
import com.ttt.app.telegram.event.MessageEvent;
import com.ttt.app.telegram.handler.AuthStateReadyHandler;
import com.ttt.app.telegram.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class AuthStateReadyHandlerImpl implements AuthStateReadyHandler {
    private final ApplicationContext context;
    private final ChatService fetcher;
    private final ChatConfig chatConfig;

    @Override
    public void onApplicationEvent(AuthStateReadyEvent event) {
        context.publishEvent(new MessageEvent("Telegram connection is ready"));
        fetcher.getMainChatSet(chatConfig.getLimit());
    }
}
