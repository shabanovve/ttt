package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.GetAuthCodeEvent;
import org.springframework.context.ApplicationListener;

public interface GetAuthCodeHandler extends ApplicationListener<GetAuthCodeEvent> {
}
