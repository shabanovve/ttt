package com.ttt.app.telegram;

import lombok.Getter;
import lombok.Setter;
import org.drinkless.tdlib.TdApi;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Component
public class ChatState {
    private final Set<TdApi.Chat> chatSet = new HashSet<>();
    private boolean haveFullChatList;
}
