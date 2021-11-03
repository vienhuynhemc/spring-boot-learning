package com.example.axon.demo.repostory;

import com.example.axon.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepostory extends JpaRepository<Department, Long> {
}
