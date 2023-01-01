package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.AuthStateReadyEvent;
import org.springframework.context.ApplicationListener;

public interface AuthStateReadyHandler extends ApplicationListener<AuthStateReadyEvent> {
}
