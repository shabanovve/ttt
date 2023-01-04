package com.ttt.app.cliapp.handler;

import com.ttt.app.telegram.AuthState;
import com.ttt.app.telegram.event.GetPasswordEvent;
import com.ttt.app.telegram.handler.GetPasswordHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetPasswordHandlerImpl extends AbstractStringDialogHandler
        implements GetPasswordHandler {
    private final AuthState authState;


    @Override
    public void onApplicationEvent(GetPasswordEvent event) {
        handle(
                "Enter password",
                result -> authState.setPassword(result.get()),
                event.getLatch(),
                true
        );
    }
}
