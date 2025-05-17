package com.example.demo.config.controller;


import com.example.demo.config.config.ConfigProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 @author kings
 @project Refactoring
 @class ConfigController
 @version 1.0.0
 @since 17.05.2025 - 23:27
*/
@RestController
@RequestMapping("/doctors/config")
public class ConfigController {

    private final ConfigProperties configProperties;

    public ConfigController(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/title")
    public String getTitle() {
        if (configProperties.getTitle() == null) {
            return "Configuration property 'project.title' not found!";
        }
        return "TITLE: " + configProperties.getTitle();
    }

    @GetMapping("/description")
    public String getDescription() {
        if (configProperties.getDescription() == null) {
            return "Configuration property 'project.description' not found!";
        }
        return "DESCRIPTION: " + configProperties.getDescription();
    }
}
