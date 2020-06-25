package com.springboot.zeus.tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootBackendTareasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendTareasApplication.class, args);
    }

}
