package com.example.demo.config.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/*
 @author kings
 @project Refactoring
 @class ConfigProperties
 @version 1.0.0
 @since 17.05.2025 - 23:53
*/
@Component
@ConfigurationProperties(prefix = "project")
@RefreshScope
public class ConfigProperties {

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
