package com.ttt.app.telegram.handler.impl;

import com.ttt.app.telegram.AuthState;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import com.ttt.app.telegram.handler.AbstractStringDialogHandler;
import com.ttt.app.telegram.handler.GetPhoneNumberHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class GetPhoneNumberHandlerImpl extends AbstractStringDialogHandler
        implements GetPhoneNumberHandler {
    private final AuthState authState;

    @Override
    public void onApplicationEvent(GetPhoneNumberEvent event) {
        handle(
                "Enter phone number",
                result -> authState.setPhoneNumber(result.get()),
                event.getLatch()
                );
    }

}
