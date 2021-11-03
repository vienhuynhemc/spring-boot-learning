package com.example.axon.demo.service;

import com.example.axon.demo.entity.Employee;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();
    ResponseEntity<ReponseObject> saveEmployee(EmployeeDTO employeeDTO);
    ResponseEntity<ReponseObject> getEmployeeById(Long id);
    ResponseEntity<ReponseObject> getAllEmployeeByDepartmentId(Long id);
    ResponseEntity<ReponseObject> updateEmployee(EmployeeDTO employeeDTO,Long id);
    ResponseEntity<ReponseObject> deleteEmployeeById(Long id);

}
