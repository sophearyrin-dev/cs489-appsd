package miu.edu.library.lesson7.citylibrarywebapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitylibrarywebapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CitylibrarywebapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");
    }
}
