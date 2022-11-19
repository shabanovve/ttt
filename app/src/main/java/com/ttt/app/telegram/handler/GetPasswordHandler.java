package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.AuthState;
import com.ttt.app.telegram.event.GetPasswordEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetPasswordHandler extends AbstractStringDialogHandler
        implements ApplicationListener<GetPasswordEvent> {
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
