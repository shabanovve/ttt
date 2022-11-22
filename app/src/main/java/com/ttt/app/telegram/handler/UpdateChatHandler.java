package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.ChatState;
import com.ttt.app.telegram.event.UpdateChatEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateChatHandler implements ApplicationListener<UpdateChatEvent> {
    private final ChatState chatState;
    @Override
    public void onApplicationEvent(UpdateChatEvent event) {
        chatState.getChatSet().add(event.getChat());
    }
}
