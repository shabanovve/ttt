package com.ttt.app.telegram.handler.impl;

import com.ttt.app.telegram.event.MessageEvent;
import com.ttt.app.telegram.event.RepeatAuthRequestEvent;
import com.ttt.app.telegram.handler.AuthorizationRequestHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class AuthorizationRequestHandlerImpl implements AuthorizationRequestHandler {
    private final ApplicationContext context;

    @Override
    public void onResult(TdApi.Object object) {
        switch (object.getConstructor()) {
            case TdApi.Error.CONSTRUCTOR -> {
                log.error(object);
                context.publishEvent(new MessageEvent("Receive an error: " + object));
                context.publishEvent(new RepeatAuthRequestEvent((TdApi.Error) object));
            }
            case TdApi.Ok.CONSTRUCTOR -> log.info(object);
            default -> {
                log.error(object);
                context.publishEvent(new MessageEvent("Receive wrong response from TDLib:" + object));
            }
        }
    }
}
