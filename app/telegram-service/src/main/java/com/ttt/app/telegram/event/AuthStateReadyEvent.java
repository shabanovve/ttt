package com.ttt.app.telegram.event;

import org.springframework.context.ApplicationEvent;

public class AuthStateReadyEvent extends ApplicationEvent {
    public AuthStateReadyEvent(Object source) {
        super(source);
    }
}
