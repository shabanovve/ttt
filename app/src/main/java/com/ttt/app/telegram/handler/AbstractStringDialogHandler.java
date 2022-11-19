package com.ttt.app.telegram.handler;

import com.ttt.app.view.StringDialog;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public abstract class AbstractStringDialogHandler {

    protected void handle(
            String title, String beanName, ConfigurableApplicationContext context,
            Function<AtomicReference<String>, Object> createBeanFunction, CountDownLatch latch
    ) {
        AtomicReference<String> result = new AtomicReference<>();
        StringDialog.create(title, result);
        context.getBeanFactory()
                .registerSingleton(
                        beanName,
                        createBeanFunction.apply(result)
                );
        latch.countDown();
    }
}
