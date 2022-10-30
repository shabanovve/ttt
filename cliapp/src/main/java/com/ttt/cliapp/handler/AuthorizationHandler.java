package com.ttt.cliapp.handler;

import com.ttt.cliapp.config.ApiConfig;
import com.ttt.cliapp.utils.Sender;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Component
public class AuthorizationHandler {
    private final ApiConfig apiConfig;
    private final Sender sender;

    public void handle(TdApi.UpdateAuthorizationState state) {
        TdApi.SetTdlibParameters request = new TdApi.SetTdlibParameters();
        request.databaseDirectory = "tdlib";
        request.useMessageDatabase = true;
        request.useSecretChats = true;
        request.apiId = apiConfig.getId();
        request.apiHash = apiConfig.getHash();
        request.systemLanguageCode = "en";
        request.deviceModel = "Desktop";
        request.applicationVersion = "1.0";
        request.enableStorageOptimizer = true;
        sender.getClient().send(request, null);
    }
}
