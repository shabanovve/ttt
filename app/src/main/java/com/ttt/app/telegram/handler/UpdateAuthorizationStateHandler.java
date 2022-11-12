package com.ttt.app.telegram.handler;


import com.ttt.app.config.ApiConfig;
import com.ttt.app.telegram.PhoneNumber;
import com.ttt.app.telegram.event.GetPhoneNumberEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Log4j2
@SuppressWarnings("unused")
@RequiredArgsConstructor
@Component
public class UpdateAuthorizationStateHandler {
    private final ApplicationContext context;
    private final AuthorizationRequestHandler authorizationRequestHandler;
    private final ApiConfig apiConfig;
    private TdApi.AuthorizationState authorizationState;


    @SneakyThrows
    public void handle(TdApi.AuthorizationState authorizationState) {
        if (authorizationState != null) {
            this.authorizationState = authorizationState;
        }
        switch (this.authorizationState.getConstructor()) {
            case TdApi.AuthorizationStateWaitTdlibParameters.CONSTRUCTOR -> {
                TdApi.SetTdlibParameters request = new TdApi.SetTdlibParameters();
                request.databaseDirectory = "tdlib";
                request.useMessageDatabase = true;
                request.useSecretChats = true;
                request.apiId = apiConfig.getId();
                request.apiHash = apiConfig.getHash();
                request.systemLanguageCode = "en";
                request.deviceModel = "Desktop";
                request.applicationVersion = "1.0";
                request.enableStorageOptimizer = true;
                context.getBean(Client.class).send(request, authorizationRequestHandler);
            }
            case TdApi.AuthorizationStateWaitPhoneNumber.CONSTRUCTOR -> {
                CountDownLatch latch = new CountDownLatch(1);
                context.publishEvent(new GetPhoneNumberEvent(latch));
                latch.await();
                String phoneNumber = context.getBean(PhoneNumber.class).value();
                log.info("Entered phone number: " + phoneNumber);
//                context.getBean(Client.class)
//                        .send(
//                                new TdApi.SetAuthenticationPhoneNumber(phoneNumber, null),
//                                authorizationRequestHandler
//                        );
            }
        }
    }

}
