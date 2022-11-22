package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.UpdateAuthorizationStateEvent;
import com.ttt.app.telegram.event.UpdateChatEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Log4j2
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
                case TdApi.UpdateNewChat.CONSTRUCTOR,
                        TdApi.UpdateChatLastMessage.CONSTRUCTOR,
                        TdApi.UpdateChatPosition.CONSTRUCTOR,
                        TdApi.UpdateChatDraftMessage.CONSTRUCTOR -> {
                    TdApi.Chat chat = ((TdApi.UpdateNewChat) object).chat;
                    context.publishEvent(new UpdateChatEvent(chat));
                }
                default -> log.info("Skip event " + object);
            }
        } else {
            throw new IllegalStateException("Cannot handle " + object.getClass().getCanonicalName());
        }
    }
}
