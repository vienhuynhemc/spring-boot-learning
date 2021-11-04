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
