package com.ttt.app.telegram.handler;

import com.ttt.app.javafxui.view.StringDialog;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
@Log4j2
public abstract class AbstractStringDialogHandler {
    private final ReentrantLock lock = new ReentrantLock();

    protected void handle(
            String title, Consumer<AtomicReference<String>> changeStateConsumer,
            CountDownLatch latch
    ) {
        handle(title, changeStateConsumer, latch, false);
    }
    @SneakyThrows
    protected void handle(
            String title, Consumer<AtomicReference<String>> changeStateConsumer,
            CountDownLatch latch, boolean isPassword
    ) {
        if (!lock.tryLock()) {
            log.info("Skip showing dialog " + title);
            return; //should not handle dialog event multiple times
        }

        try {
            AtomicReference<String> result = new AtomicReference<>();
            StringDialog.createAndGetLatch(title, result, isPassword).await();
            changeStateConsumer.accept(result);
        } finally {
            latch.countDown();
            lock.unlock();
        }
    }
}
