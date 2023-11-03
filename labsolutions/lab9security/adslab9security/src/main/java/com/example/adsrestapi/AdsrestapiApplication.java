package com.example.adsrestapi;

import com.example.adsrestapi.model.Role;
import com.example.adsrestapi.model.User;
import com.example.adsrestapi.repository.RoleRepository;
import com.example.adsrestapi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdsrestapiApplication {

    private UserRepository userRepository;

    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AdsrestapiApplication(UserRepository userRepository,
                                        RoleRepository roleRepository,
                                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(AdsrestapiApplication.class, args);
    }

    @PostConstruct
    public void initAdminUser() {
        var adminUser = userRepository.findUserByUsername("admin");
        if(adminUser.isEmpty()) {
            List<Role> listAdminRoles = new ArrayList<>();
            var adminRole = roleRepository.findRoleByName("ROLE_ADMIN");
            if(adminRole.isEmpty()) {
                var newAdminRole =  new Role(null, "ROLE_ADMIN");
                listAdminRoles.add(newAdminRole);
            } else {
                listAdminRoles.add(adminRole.get());
            }
            User newAdminUser = new User(null, "Admin", "Admin", "Admin", "admin",
                    passwordEncoder.encode("test1234"), "admin@advantis.com",
                    true,true, true, true);
            newAdminUser.setRoles(listAdminRoles);
            userRepository.save(newAdminUser);
        }
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("Hello RESTful Web API");
            System.out.println("Advantis WebAPI server. Starting...");
            System.out.println("Advantis WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8080");
            System.out.println("To see list of Publishers, send HTTP GET Request to the URI,\nhttp://localhost:8080/adsweb/api/v1/address/list");
        };
    }

}
