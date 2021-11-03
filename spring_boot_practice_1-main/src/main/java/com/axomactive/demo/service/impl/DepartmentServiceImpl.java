package com.axomactive.demo.service.impl;

import com.axomactive.demo.entity.Department;
import com.axomactive.demo.entity.LocationEnum;
import com.axomactive.demo.repository.DepartmentRepository;
import com.axomactive.demo.service.DepartmentService;
import com.axomactive.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl  implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(DepartmentDTO departmentDTO) {
        Department department= new Department();
        department.setName(departmentDTO.getName());
        department.setLocation(departmentDTO.getLocation());

        return departmentRepository.save(department);
    }
}
