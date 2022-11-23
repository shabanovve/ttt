package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.ChatState;
import com.ttt.app.telegram.event.UpdateChatEvent;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateChatHandler implements ApplicationListener<UpdateChatEvent> {
    private final ChatState chatState;
    private final ApplicationContext context;
    @Override
    public void onApplicationEvent(UpdateChatEvent event) {
        TdApi.Chat chat = event.getChat();
        if (chat.title.toLowerCase().contains("lcc")) {
            chatState.getChatSet().add(chat);
            chatState.getChatMap().put(chat.id, chat);
        }
    }
}
