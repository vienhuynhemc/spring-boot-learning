package com.example.axon.demo.controller;

import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.service.dto.DepartmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
public interface DepartmentController {
    @GetMapping("")
    List<Department> getAllDepartment();
    @GetMapping("/{id}")
    ResponseEntity<ReponseObject> getDepartmentById(@PathVariable Long id);
    @PostMapping
    Department saveDepartment(@RequestBody DepartmentDTO department);
    @PutMapping("")
    Department updateDepartment(@RequestBody Department department);
    @DeleteMapping("/{id}")
    ResponseEntity<ReponseObject> deleteDepartmentById(@PathVariable Long id);

}
