package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.UpdateChatEvent;
import org.springframework.context.ApplicationListener;

public interface UpdateChatHandler extends ApplicationListener<UpdateChatEvent> {
}
