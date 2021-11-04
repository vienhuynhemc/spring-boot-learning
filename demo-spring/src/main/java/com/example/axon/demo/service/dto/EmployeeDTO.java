package com.example.axon.demo.service.dto;

import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.GenderEnum;
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
