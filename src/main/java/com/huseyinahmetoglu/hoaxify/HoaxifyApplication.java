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
//                for (int i = 0; i < 50; i++) {
//                    User user = new User();
//                    user.setUsername("user" + i);
//                    user.setPassword("Parola123");
//                    user.setDisplayName("display" + i);
//                    userService.save(user);
//                }
//            }
//        };
//    }

}
