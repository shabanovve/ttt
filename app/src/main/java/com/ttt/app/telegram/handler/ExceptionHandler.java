package com.ttt.app.telegram.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class ExceptionHandler implements Client.ExceptionHandler{

    @Override
    public void onException(Throwable throwable) {
       log.error(throwable);
    }
}
