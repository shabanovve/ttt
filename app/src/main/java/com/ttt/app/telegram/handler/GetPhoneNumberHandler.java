package com.ttt.app.telegram.handler;

import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import org.springframework.context.ApplicationListener;

public interface GetPhoneNumberHandler extends ApplicationListener<GetPhoneNumberEvent> {
}
