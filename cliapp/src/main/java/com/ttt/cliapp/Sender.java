package com.ttt.cliapp;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class Sender {
    @NonNull
    private final ApplicationContext context;

    public @NonNull Client getClient() {
        return context.getBean(Client.class);
    }
}
