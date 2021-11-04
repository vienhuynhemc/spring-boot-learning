package com.axonactive.demo_spring.repostory;

import com.axonactive.demo_spring.entity.Department;
import com.axonactive.demo_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepostory extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e where e.department = ?1")
    List<Employee> findAllEmployeeByIdDepartment(Department department);
}
