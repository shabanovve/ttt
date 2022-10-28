package com.ttt.cliapp;

import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@Component
public class UpdateHandler implements Client.ResultHandler {
    @Override
    public void onResult(TdApi.Object object) {

    }
}
