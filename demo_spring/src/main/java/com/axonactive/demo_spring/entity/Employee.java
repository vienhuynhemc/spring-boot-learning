package com.axonactive.demo_spring.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

// khai báo nó là thực thể
@Entity
// get set
@Data
// contructor đầy đủ thuộc tính
@AllArgsConstructor
// contructor không có thuộc tính
@NoArgsConstructor
public class Employee {
    // id là primary ley
    @Id
    // tự đông tăng Auto là sài chung tất cả các thực thể, Identity là mỗi thực thể tự có số tăng riêng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // cột này không thể null
    @Column(
            nullable = false
    )
    @NotNull
    // size phải từ 15 - 50
    @Size(min = 5, max = 50)
    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private LocalDate doB;

    // email phải duy nhất
    @Column(
     unique = true
    )
    private String email;
    private String address;
    private String city;

    // quan hệ nhiều 1
    @ManyToOne
    // khóa ngoại với tên là department_id
    @JoinColumn(name = "department_id")
    private Department department;
}
