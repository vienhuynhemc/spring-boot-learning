package com.axonactive.demo_spring.service;

import com.axonactive.demo_spring.entity.Department;
import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.service.dto.DepartmentDTO;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<ReponseObject>  getAllDepartment();
    ResponseEntity<ReponseObject> saveDepartment(DepartmentDTO departmentDTO);
    ResponseEntity<ReponseObject> getDepartmentById(Long id);
    ResponseEntity<ReponseObject> updateDepartment(Department department);
    ResponseEntity<ReponseObject> deleteDepartmentById(Long id);
}
