package com.ttt.app.telegram.listner;

import com.ttt.app.telegram.event.UpdateAuthorizationStateEvent;
import com.ttt.app.telegram.service.UpdateAuthorizationStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class UpdateAuthorizationStateListener implements ApplicationListener<UpdateAuthorizationStateEvent> {
    private final UpdateAuthorizationStateService updateAuthorizationStateHandler;
    @Override
    public void onApplicationEvent(UpdateAuthorizationStateEvent event) {
        updateAuthorizationStateHandler.handle(event.getAuthorizationState());
    }
}
