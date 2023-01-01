package com.ttt.app.telegram.handler.impl;

import com.ttt.app.telegram.ChatState;
import com.ttt.app.telegram.config.ChatConfig;
import com.ttt.app.telegram.event.UpdateChatEvent;
import com.ttt.app.telegram.handler.UpdateChatHandler;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateChatHandlerImpl implements UpdateChatHandler {
    private final ChatState chatState;
    private final ChatConfig chatConfig;
    @Override
    public void onApplicationEvent(UpdateChatEvent event) {
        TdApi.Chat chat = event.getChat();
        if (chat.title.toLowerCase().contains(chatConfig.getTitlePart())) {
            chatState.getChatSet().add(chat);
            chatState.getChatMap().put(chat.id, chat);
        }
    }
}
