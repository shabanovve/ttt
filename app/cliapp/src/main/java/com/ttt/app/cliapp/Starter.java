package com.ttt.app.cliapp;

import com.ttt.app.telegram.TelegramService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Starter  {
    private final TelegramService telegramService;

    @PostConstruct
    private void start() {
        telegramService.start();
    }
}
