package com.telefonica.efikaauth.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.telefonica.efikaauth","com.telefonica.efikaauth.controller"
,"com.telefonica.efikaauth.security"} )
@EntityScan("com.telefonica.efikaauth.model")
@EnableJpaRepositories("com.telefonica.efikaauth.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
}
