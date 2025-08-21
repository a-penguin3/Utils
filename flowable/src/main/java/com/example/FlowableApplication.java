package com.example;

import com.example.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
public class FlowableApplication {
    public static void main(String[] args) {
//        SpringApplication.run(FlowableApplication.class, args);
        SpringApplication application = new SpringApplication(FlowableApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
    }

    @Bean
    public CommandLineRunner init(final MyService myService) {

        return strings -> myService.createDemoUsers();
    }

}