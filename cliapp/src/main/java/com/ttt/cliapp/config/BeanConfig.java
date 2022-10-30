package com.ttt.cliapp.config;

import com.ttt.cliapp.handler.UpdateHandler;
import lombok.NonNull;
import org.drinkless.tdlib.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {
    @Bean
    public Client client(@NonNull UpdateHandler updateHandler) {
        return Client.create(updateHandler, null, null);
    }
}
