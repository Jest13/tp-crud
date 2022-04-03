package com.example.back;

import com.example.back.model.Role;
import com.example.back.model.User;
import com.example.back.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
/* @CrossOrigin(origins = "*") */
public class BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Donald Trump", "Donald", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Floriant Phillipot", "Phillipot", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Eric Popoye", "Popoye", "1234", new ArrayList<>()));

            userService.addRoleToUser("John", "ROLE_USER");
            userService.addRoleToUser("Donald", "ROLE_ADMIN");
            userService.addRoleToUser("Phillipot", "ROLE_MANAGER");
            userService.addRoleToUser("Popoye", "ROLE_SUPER_ADMIN");

        };
    }
}
