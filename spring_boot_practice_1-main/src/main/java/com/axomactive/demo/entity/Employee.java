package com.axomactive.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false
    )
    @NotNull
    @Size(min = 15, max = 50)
    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private LocalDate DoB;

    @Column(
            unique = true
    )
    private String email;
    private String address;
    private String City;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
