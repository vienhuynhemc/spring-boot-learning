package com.axonactive.demo_spring.repostory;

import com.axonactive.demo_spring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepostory extends JpaRepository<Department, Long> {
}
