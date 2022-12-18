package com.ttt.app.view.handler;

import com.ttt.app.telegram.event.MessageEvent;
import com.ttt.app.view.MessageStringView;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageEventHandler implements ApplicationListener<MessageEvent> {
    private final MessageStringView messageStringView;

    @Override
    public void onApplicationEvent(MessageEvent event) {
        messageStringView.addMessage((String) event.getSource());
    }
}
