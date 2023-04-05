package com.producter.playermanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private static String DATABASE_CONSOLE;
    private static Integer SERVER_PORT;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------------------------------");
        System.out.println("H2 Database Console Path: " + DATABASE_CONSOLE);
        System.out.println("Server Port: " + SERVER_PORT);
        System.out.println("---------------------------------------------");
    }

    @Value("${spring.h2.console.path}")
    public void setUsername(String path) {
        DataLoader.DATABASE_CONSOLE = "http://localhost:8080" + path;
    }

    @Value("${server.port}")
    public void setServerPort(int port) {
        DataLoader.SERVER_PORT = port;
    }
}

