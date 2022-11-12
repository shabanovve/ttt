package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.UpdateAuthorizationStateEvent;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResultHandler implements Client.ResultHandler {
    private final ConfigurableApplicationContext context;

    @Override
    public void onResult(TdApi.Object object) {
        if (object instanceof TdApi.Update) {
            switch (object.getConstructor()) {
                case TdApi.UpdateAuthorizationState.CONSTRUCTOR -> {
                    TdApi.AuthorizationState authorizationState =
                            ((TdApi.UpdateAuthorizationState) object).authorizationState;
                    context.publishEvent(new UpdateAuthorizationStateEvent(authorizationState));
                }
            }
        } else {
            throw new IllegalStateException("Cannot handle " + object.getClass().getCanonicalName());
        }
    }
}
