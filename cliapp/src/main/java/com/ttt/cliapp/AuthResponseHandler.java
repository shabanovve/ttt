package com.ttt.cliapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class AuthResponseHandler extends AbstractHandler implements Client.ResultHandler{
    private final AuthorizationHandler authorizationHandler;
    @Override
    public void onResult(TdApi.Object object) {
        switch (object.getConstructor()) {
            case TdApi.Error.CONSTRUCTOR:
                log.error("Receive an error:" + newLine + object);
                authorizationHandler.handle(null); // repeat last action
                break;
            case TdApi.Ok.CONSTRUCTOR:
                // result is already received through UpdateAuthorizationState, nothing to do
                break;
            default:
                log.error("Receive wrong response from TDLib:" + newLine + object);
        }
    }
}
