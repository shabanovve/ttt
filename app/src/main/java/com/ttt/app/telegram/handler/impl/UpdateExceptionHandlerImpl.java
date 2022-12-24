package com.ttt.app.telegram.handler.impl;

import com.ttt.app.telegram.config.TelegramLogConfig;
import com.ttt.app.telegram.handler.UpdateExceptionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class UpdateExceptionHandlerImpl implements UpdateExceptionHandler {
    private final TelegramLogConfig telegramLogConfig;

    @Override
    public void onException(Throwable throwable) {
        if (telegramLogConfig.isEnableUpdateExceptionLogger()) {
            log.error(throwable);
            throwable.printStackTrace();
        }
    }
}
