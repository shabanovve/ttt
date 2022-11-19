package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.PhoneNumber;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import com.ttt.app.view.StringDialog;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class GetPhoneNumberHandler implements ApplicationListener<GetPhoneNumberEvent> {
    private final ConfigurableApplicationContext context;
    @Override
    public void onApplicationEvent(GetPhoneNumberEvent event) {
        CountDownLatch latch = event.getLatch();
        String title = "Enter phone number";
        AtomicReference<String> result = new AtomicReference<>();
        StringDialog.create(title, result);
        context.getBeanFactory()
                .registerSingleton(
                        "phoneNumber",
                        new PhoneNumber(result.get())
                );
        latch.countDown();
    }

}
