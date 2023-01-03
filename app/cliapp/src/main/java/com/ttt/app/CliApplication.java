package com.ttt.app;

import com.ttt.app.telegram.config.ChatConfig;
import com.ttt.app.telegram.config.TelegramApiConfig;
import com.ttt.app.telegram.config.TelegramLogConfig;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({TelegramApiConfig.class, TelegramLogConfig.class, ChatConfig.class})
public class CliApplication {
    @SuppressWarnings("InfiniteLoopStatement")
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class, args);
        while (true) {
            //noinspection BusyWait
            Thread.sleep(100);
        }
    }

}
