package com.ttt.cliapp;

import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Component
public class AuthorizationHandler {
    private final Sender sender;

    public void handle(TdApi.UpdateAuthorizationState state) {
        TdApi.SetTdlibParameters request = new TdApi.SetTdlibParameters();
        request.databaseDirectory = "tdlib";
        request.useMessageDatabase = true;
        request.useSecretChats = true;
        request.apiId = 699281;
        request.apiHash = "c638b3215d18e64f42374fcf43f48e69";
        request.systemLanguageCode = "en";
        request.deviceModel = "Desktop";
        request.applicationVersion = "1.0";
        request.enableStorageOptimizer = true;
        sender.getClient().send(request, null);
    }
}