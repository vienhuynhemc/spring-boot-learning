package com.axonactive.simple_meta.configuration;

import com.axonactive.simple_meta.enity.Account;
import com.axonactive.simple_meta.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository userRepository) {
        return args -> {
            Account account1 = new Account();
            account1.setUserName("user1");
            account1.setPassword("user1");
            Account account2 = new Account();
            account2.setUserName("user2");
            account2.setPassword("user2");
            userRepository.saveAll(
                    List.of(
                            account1,
                            account2
                    )
            );
        };
    }

}
