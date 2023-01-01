package com.ttt.app.javafxui.view.handler;

import com.ttt.app.telegram.AuthState;
import com.ttt.app.telegram.event.GetAuthCodeEvent;
import com.ttt.app.telegram.handler.GetAuthCodeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAuthCodeHandlerImpl extends AbstractStringDialogHandler
        implements GetAuthCodeHandler {
    private final AuthState authState;

    @Override
    public void onApplicationEvent(GetAuthCodeEvent event) {
        handle(
                "Enter authorization code",
                result -> authState.setAuthCode(result.get()),
                event.getLatch()
        );
    }
}
