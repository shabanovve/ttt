package com.ttt.app.telegram.handler.impl;

import com.ttt.app.telegram.event.MessageEvent;
import com.ttt.app.telegram.event.NewMessageEvent;
import com.ttt.app.telegram.handler.NewMessageHandler;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NewMessageHandlerImpl implements NewMessageHandler {
    private final ApplicationContext context;

    @Override
    public void onApplicationEvent(NewMessageEvent event) {
        TdApi.UpdateNewMessage updateNewMessage = event.getUpdateNewMessage();
        TdApi.MessageContent content = updateNewMessage.message.content;
        if (content.getConstructor() == TdApi.MessageText.CONSTRUCTOR) {
            String text = ((TdApi.MessageText)content).text.text;
            context.publishEvent(new MessageEvent("Got message: " + text));
        }
    }
}
