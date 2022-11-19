package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.AuthStateReadyEvent;
import com.ttt.app.view.event.MessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class AuthStateReadyHandler implements ApplicationListener<AuthStateReadyEvent> {
    private final ApplicationContext context;

    @Override
    public void onApplicationEvent(AuthStateReadyEvent event) {
        context.publishEvent(new MessageEvent("Telegram connection is ready"));
    }
}
