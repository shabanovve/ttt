package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.AuthState;
import com.ttt.app.telegram.event.GetAuthCodeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAuthCodeHandler extends AbstractStringDialogHandler
        implements ApplicationListener<GetAuthCodeEvent> {
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
