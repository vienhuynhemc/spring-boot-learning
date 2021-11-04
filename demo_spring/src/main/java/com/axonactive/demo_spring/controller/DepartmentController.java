package com.axonactive.demo_spring.controller;

import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.entity.Department;
import com.axonactive.demo_spring.service.dto.DepartmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
public interface DepartmentController {
    @GetMapping("")
    ResponseEntity<ReponseObject> getAllDepartment();
    @GetMapping("/{id}")
    ResponseEntity<ReponseObject> getDepartmentById(@PathVariable Long id);
    @PostMapping
    ResponseEntity<ReponseObject> saveDepartment(@RequestBody DepartmentDTO department);
    @PutMapping("")
    ResponseEntity<ReponseObject> updateDepartment(@RequestBody Department department);
    @DeleteMapping("/{id}")
    ResponseEntity<ReponseObject> deleteDepartmentById(@PathVariable Long id);

}
