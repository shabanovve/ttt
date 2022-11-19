package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.PhoneNumber;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class GetPhoneNumberHandler extends AbstractStringDialogHandler
        implements ApplicationListener<GetPhoneNumberEvent> {
    private final ConfigurableApplicationContext context;

    @Override
    public void onApplicationEvent(GetPhoneNumberEvent event) {
        handle(
                "Enter phone number", "phoneNumber", context,
                result -> new PhoneNumber(result.get()),
                event.getLatch()
                );
    }

}
