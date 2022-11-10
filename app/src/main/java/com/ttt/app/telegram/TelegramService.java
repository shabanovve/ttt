package com.ttt.app.telegram;

import com.ttt.app.view.MessageStringView;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class TelegramService {
    private final MessageStringView messageStringView;
    public void start() {
        String message = "Connect to telegram";
        log.info(message);
        messageStringView.addMessage(message);
    }
}
