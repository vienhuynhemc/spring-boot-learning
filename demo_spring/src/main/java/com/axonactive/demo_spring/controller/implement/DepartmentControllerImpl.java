package com.axonactive.demo_spring.controller.implement;

import com.axonactive.demo_spring.controller.DepartmentController;
import com.axonactive.demo_spring.entity.Department;
import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.service.DepartmentService;
import com.axonactive.demo_spring.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
