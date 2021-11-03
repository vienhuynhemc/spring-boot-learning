package com.example.axon.demo.controller.implement;

import com.example.axon.demo.controller.EmployeeController;
import com.example.axon.demo.entity.Employee;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.service.EmployeeService;
import com.example.axon.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;
    @Override
    public List<Employee> getAllEmployee() {
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
