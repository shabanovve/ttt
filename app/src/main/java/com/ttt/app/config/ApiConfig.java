package com.ttt.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "api")
public class ApiConfig {
    private int id;
    private String hash;
}
