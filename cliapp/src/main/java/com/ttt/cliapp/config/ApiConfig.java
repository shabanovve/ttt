package com.ttt.cliapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "api")
public class ApiConfig {
    int id;
    String hash;
}
