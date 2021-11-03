package com.axomactive.demo.controller.impl;

import com.axomactive.demo.controller.DepartmentController;
import com.axomactive.demo.entity.Department;
import com.axomactive.demo.service.DepartmentService;
import com.axomactive.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentControllerImpl implements DepartmentController {

    private  final DepartmentService departmentService;

    @Override
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @Override
    public Department saveDepartment(DepartmentDTO departmentDTO) {
        return  departmentService.saveDepartment(departmentDTO);
    }
}
