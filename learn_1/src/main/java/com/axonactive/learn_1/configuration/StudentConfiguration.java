package com.axonactive.learn_1.configuration;

import com.axonactive.learn_1.entity.Student;
import com.axonactive.learn_1.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student s1 = new Student();
            Student s2 = new Student();
            s1.setName("ABC");
            s1.setAge(14);
            s1.setEmail("abc@email");
            s2.setName("ABC");
            s2.setAge(14);
            s2.setEmail("abc@email");
            studentRepository.saveAll(
                    List.of(
                            s1,
                            s2
                    )
            );
        };
    }

}
