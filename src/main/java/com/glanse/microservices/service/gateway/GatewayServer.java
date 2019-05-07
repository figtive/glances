package com.glanse.microservices.service.gateway;

import com.glanse.microservices.common.DatabaseConfiguration;
import com.glanse.microservices.service.gateway.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@Import({DatabaseConfiguration.class, WebSecurityConfig.class})
public class GatewayServer {
    public static void main(String[] args) {
        System.out.println("Gateway Server running!");
        System.setProperty("spring.config.name", "gateway");
        SpringApplication.run(GatewayServer.class, args);
    }
}
