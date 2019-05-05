package com.glanse.microservices.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "eureka");
        SpringApplication.run(EurekaServer.class);
    }
}
