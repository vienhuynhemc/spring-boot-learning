package com.axonactive.demo_spring.controller.implement;

import com.axonactive.demo_spring.controller.EmployeeController;
import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.service.EmployeeService;
import com.axonactive.demo_spring.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;
    @Override
    public ResponseEntity<ReponseObject>  getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @Override
    public ResponseEntity<ReponseObject> saveEmployee(EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @Override
    public ResponseEntity<ReponseObject> getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    @Override
    public ResponseEntity<ReponseObject> updateEmployee(EmployeeDTO employeeDTO,Long id) {
        return employeeService.updateEmployee(employeeDTO,id);
    }

    @Override
    public ResponseEntity<ReponseObject> deleteEmployeeById(Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @Override
    public ResponseEntity<ReponseObject> getAllEmployeeByDepartmentId(Long id) {
        return employeeService.getAllEmployeeByDepartmentId(id);
    }
}
