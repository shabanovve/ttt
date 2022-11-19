package com.ttt.app.telegram.handler;

import com.ttt.app.config.TelegramLogConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class UpdateExceptionHandler implements Client.ExceptionHandler{
    private final TelegramLogConfig telegramLogConfig;

    @Override
    public void onException(Throwable throwable) {
        if (telegramLogConfig.isEnableUpdateExceptionLogger()) {
            log.error(throwable);
            throwable.printStackTrace();
        }
    }
}
