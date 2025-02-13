package ru.sberuniversity.springframework.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.config")
@Getter
@Setter
public class PropertiesConfig {
    private String source;
    private String target;
    private int threadsCount;
    private int downloadSpeed;
}
