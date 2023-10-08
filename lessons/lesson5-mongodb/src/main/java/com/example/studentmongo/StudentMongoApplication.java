package com.example.studentmongo;

import com.example.studentmongo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentMongoApplication {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentMongoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return (args) -> {
            //Read data from database
            List<Student> students = studentRepository.findAll();
            students.stream().forEach(System.out::println);
        };
    }




}
