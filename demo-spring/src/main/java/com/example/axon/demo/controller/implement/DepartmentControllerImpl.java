package com.example.axon.demo.controller.implement;

import com.example.axon.demo.controller.DepartmentController;
import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.service.DepartmentService;
import com.example.axon.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentControllerImpl implements DepartmentController {

    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<ReponseObject> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @Override
    public ResponseEntity<ReponseObject> getDepartmentById(Long id) {
        return departmentService.getDepartmentById(id);
    }
    @Override
    public ResponseEntity<ReponseObject> saveDepartment(DepartmentDTO department) {
        return departmentService.saveDepartment(department);
    }

    @Override
    public ResponseEntity<ReponseObject> updateDepartment(Department department) {
        return departmentService.updateDepartment(department);
    }

    @Override
    public ResponseEntity<ReponseObject> deleteDepartmentById(Long id) {
        return departmentService.deleteDepartmentById(id);
    }
}
