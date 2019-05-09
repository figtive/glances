package com.glanse.microservices.service;

import com.glanse.microservices.service.account.AccountServer;
import com.glanse.microservices.service.gateway.GatewayServer;
import com.glanse.microservices.service.registry.EurekaServer;
import com.glanse.microservices.service.web.WebServer;

public class Main {
    public static void main(String[] args) {
        String targetServer;
        if (args.length == 1) {
            targetServer = args[0];
        } else {
            usage();
            return;
        }
        if (targetServer.equalsIgnoreCase("registry")) {
            EurekaServer.main(args);
        } else if (targetServer.equalsIgnoreCase("gateway")) {
            GatewayServer.main(args);
        } else if (targetServer.equalsIgnoreCase("web")) {
            WebServer.main(args);
        } else if (targetServer.equalsIgnoreCase("account")) {
            AccountServer.main(args);
        } else {
            System.out.printf("Unknown service : %s\n", targetServer);
            usage();
        }
    }

    private static void usage() {
        System.out.println("Usage: java -jar ... <service-name>");
    }
}
