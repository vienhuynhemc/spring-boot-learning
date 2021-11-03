package com.example.axon.demo.repostory;

import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepostory extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e where e.department = ?1")
    List<Employee> findAllEmployeeByIdDepartment(Department department);
}
