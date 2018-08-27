package com.telefonica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Tiago Iwamoto - tiago.iwamoto@gmail.com
 * Criado em: 17/02/2018 - 23:10
 */

@SpringBootApplication
public class App extends SpringBootServletInitializer {

    /* Rodando no servidor */
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(App.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}

