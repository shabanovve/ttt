package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.ErrorState;
import com.ttt.app.telegram.event.RepeatAuthRequestEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class RepeatAuthRequestListener implements ApplicationListener<RepeatAuthRequestEvent> {
    private final UpdateAuthorizationStateHandler updateAuthorizationStateHandler;
    private final ErrorState errorState;

    @Override
    public void onApplicationEvent(RepeatAuthRequestEvent event) {
        errorState.countError(event.getError());
        updateAuthorizationStateHandler.handle(null);
    }
}
