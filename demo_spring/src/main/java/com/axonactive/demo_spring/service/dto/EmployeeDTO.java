package com.axonactive.demo_spring.service.dto;

import com.axonactive.demo_spring.entity.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private LocalDate DoB;
    private String email;
    private String address;
    private String city;
    private long department;

}
