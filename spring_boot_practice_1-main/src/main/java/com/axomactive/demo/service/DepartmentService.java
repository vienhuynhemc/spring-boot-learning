package com.axomactive.demo.service;

import com.axomactive.demo.entity.Department;
import com.axomactive.demo.service.dto.DepartmentDTO;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department saveDepartment(DepartmentDTO departmentDTO);
}
