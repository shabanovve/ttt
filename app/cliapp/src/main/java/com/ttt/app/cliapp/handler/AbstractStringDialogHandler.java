package com.ttt.app.cliapp.handler;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.Console;
import java.util.Scanner;
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
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== " + title);
            if (isPassword) {
                result.set(readPassword());
            } else {
                result.set(scanner.nextLine());
            }
            changeStateConsumer.accept(result);
        } finally {
            latch.countDown();
            lock.unlock();
        }
    }

    public String readPassword() {
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("Couldn't get Console instance");
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your password: ");
        return new String(passwordArray);
    }
}
