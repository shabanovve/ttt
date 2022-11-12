package com.ttt.app.view.handler;

import com.ttt.app.view.MessageStringView;
import com.ttt.app.view.event.MessageEvent;
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
