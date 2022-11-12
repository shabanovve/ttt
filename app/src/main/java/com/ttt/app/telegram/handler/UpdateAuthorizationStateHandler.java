package com.ttt.app.telegram.handler;


import com.ttt.app.config.ApiConfig;
import com.ttt.app.telegram.event.UpdateAuthorizationStateEvent;
import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateAuthorizationStateHandler implements ApplicationListener<UpdateAuthorizationStateEvent> {
    private final ApplicationContext context;
    private final AuthorizationRequestHandler authorizationRequestHandler;
    private final ApiConfig apiConfig;

    @Override
    public void onApplicationEvent(UpdateAuthorizationStateEvent event) {
        handle(event.getAuthorizationState());
    }

    private void handle(TdApi.AuthorizationState authorizationState) {
        switch (authorizationState.getConstructor()) {
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
        }
    }

}
