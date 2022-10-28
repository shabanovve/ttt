package com.ttt.cliapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class UpdateHandler implements Client.ResultHandler {
    private final AuthorizationHandler authorizationHandler;
    @Override
    public void onResult(TdApi.Object object) {
        if (object instanceof TdApi.Update) {
            if (object instanceof TdApi.UpdateAuthorizationState) {
                authorizationHandler.handle((TdApi.UpdateAuthorizationState) object);
            }
            log.info("Skip update type " + object.getClass().getCanonicalName());
        }
        throw new IllegalArgumentException("Unhandled object type " + object.getClass().getCanonicalName());
    }
}
