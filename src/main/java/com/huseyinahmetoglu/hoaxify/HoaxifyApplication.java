package com.huseyinahmetoglu.hoaxify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HoaxifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoaxifyApplication.class, args);
    }

//    @Bean
//    CommandLineRunner createInitialUser(UserService userService) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                User user = new User();
//                user.setUsername("user1");
//                user.setPassword("P4ssword");
//                user.setDisplayName("display1");
//                userService.save(user);
//            }
//        };
//    }

}
