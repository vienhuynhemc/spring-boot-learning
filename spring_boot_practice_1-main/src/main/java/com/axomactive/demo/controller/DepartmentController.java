package com.axomactive.demo.controller;

import com.axomactive.demo.entity.Department;
import com.axomactive.demo.service.dto.DepartmentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/department")
public interface DepartmentController {

    @GetMapping
    List<Department> getAllDepartments();

    @PostMapping
    Department saveDepartment(@RequestBody DepartmentDTO departmentDTO);



}
