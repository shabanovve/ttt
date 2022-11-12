package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.PhoneNumber;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class GetPhoneNumberHandler implements ApplicationListener<GetPhoneNumberEvent> {
    private final ConfigurableApplicationContext context;
    @Override
    public void onApplicationEvent(GetPhoneNumberEvent event) {
        CountDownLatch latch = event.getLatch();
        context.getBeanFactory()
                .registerSingleton(
                        "phoneNumber",
                        new PhoneNumber("+71112223344")
                );
        latch.countDown();
    }
}
