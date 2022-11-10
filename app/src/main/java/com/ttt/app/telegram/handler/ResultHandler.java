package com.ttt.app.telegram.handler;

import com.ttt.app.view.MessageStringView;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResultHandler implements Client.ResultHandler{
    private final MessageStringView messageStringView;
    @Override
    public void onResult(TdApi.Object object) {
        messageStringView.addMessage("onResult");
    }
}
