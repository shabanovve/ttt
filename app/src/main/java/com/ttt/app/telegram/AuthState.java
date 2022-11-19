package com.ttt.app.telegram;

import lombok.Getter;
import lombok.Setter;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AuthState {
    private TdApi.AuthorizationState state;
    private String phoneNumber;
    private String authCode;
}
