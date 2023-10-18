package edu.miu.cs.cs489.lesson7.citylibraryapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CitylibrarywebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitylibrarywebapiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("Hello RESTful Web API");
            System.out.println("CityLibrary WebAPI server. Starting...");
            System.out.println("CityLibrary WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8080");
            System.out.println("To see list of Publishers, send HTTP GET Request to the URI,\nhttp://localhost:8080/citylibrary/api/v1/publisher/list");
        };
    }

}
