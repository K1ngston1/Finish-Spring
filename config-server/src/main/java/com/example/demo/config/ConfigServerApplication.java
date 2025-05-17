package com.example.demo.config;

/*
 @author kings
 @project Refactoring
 @class ConfigServerApplication
 @version 1.0.0
 @since 17.05.2025 - 21:19
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
