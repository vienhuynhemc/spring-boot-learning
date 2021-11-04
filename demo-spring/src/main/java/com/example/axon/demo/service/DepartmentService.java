package com.example.axon.demo.service;

import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.service.dto.DepartmentDTO;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<ReponseObject>  getAllDepartment();
    ResponseEntity<ReponseObject> saveDepartment(DepartmentDTO departmentDTO);
    ResponseEntity<ReponseObject> getDepartmentById(Long id);
    ResponseEntity<ReponseObject> updateDepartment(Department department);
    ResponseEntity<ReponseObject> deleteDepartmentById(Long id);
}
