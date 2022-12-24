package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.NewMessageEvent;
import org.springframework.context.ApplicationListener;

public interface NewMessageHandler extends ApplicationListener<NewMessageEvent> {
}
