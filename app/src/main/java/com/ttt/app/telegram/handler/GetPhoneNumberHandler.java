package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.AuthState;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class GetPhoneNumberHandler extends AbstractStringDialogHandler
        implements ApplicationListener<GetPhoneNumberEvent> {
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
