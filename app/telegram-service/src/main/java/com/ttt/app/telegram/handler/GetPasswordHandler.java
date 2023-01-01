package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.GetPasswordEvent;
import org.springframework.context.ApplicationListener;

public interface GetPasswordHandler extends ApplicationListener<GetPasswordEvent> {
}
