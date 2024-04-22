package com.glanse.microservices.service.web;

import com.glanse.microservices.common.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import({DatabaseConfiguration.class})
public class WebServer {
    public static void main(String[] args) {
        System.out.println("Web Server running!");
        System.setProperty("spring.config.name", "web");
        SpringApplication.run(WebServer.class, args);
    }
}
