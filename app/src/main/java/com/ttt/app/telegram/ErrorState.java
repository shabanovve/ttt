package com.ttt.app.telegram;

import lombok.Getter;
import lombok.Setter;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Getter
@Setter
@Component
public class ErrorState {
    private static final Integer MAX_COUNT_ERROR = 10;
    private static final Map<TdApi.Error, Integer> errorCounter = new HashMap<>();
    public void countError(TdApi.Error error) {
        Integer count = errorCounter.get(error);
        if (count == null) {
            errorCounter.put(error, 1);
        } else {
            if (count > MAX_COUNT_ERROR) {
                throw new IllegalStateException("Too many error " + error);
            }
            errorCounter.put(error, ++count);
        }
    }
}
