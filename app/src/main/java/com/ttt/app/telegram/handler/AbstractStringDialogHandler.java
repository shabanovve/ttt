package com.ttt.app.telegram.handler;

import com.ttt.app.view.StringDialog;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
@Log4j2
public abstract class AbstractStringDialogHandler {
    private final ReentrantLock lock = new ReentrantLock();
    @SneakyThrows
    protected void handle(
            String title, String beanName, ConfigurableApplicationContext context,
            Function<AtomicReference<String>, Object> createBeanFunction, CountDownLatch latch
    ) {
        if (!lock.tryLock()) {
            log.info("Skip showing dialog " + title);
            return; //should not handle dialog event multiple times
        }

        try {
            AtomicReference<String> result = new AtomicReference<>();
            StringDialog.createAndGetLatch(title, result).await();
            context.getBeanFactory()
                    .registerSingleton(
                            beanName,
                            createBeanFunction.apply(result)
                    );
        } finally {
            latch.countDown();
            lock.unlock();
        }
    }
}
