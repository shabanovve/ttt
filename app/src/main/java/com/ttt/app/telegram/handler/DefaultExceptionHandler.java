package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.config.TelegramLogConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class DefaultExceptionHandler implements Client.ExceptionHandler{
    private final TelegramLogConfig telegramLogConfig;

    @Override
    public void onException(Throwable throwable) {
        if (telegramLogConfig.isEnableDefaultExceptionLogger()) {
            log.error(throwable);
            throwable.printStackTrace();
        }
    }
}
