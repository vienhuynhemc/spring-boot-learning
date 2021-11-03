package com.example.axon.demo.controller;

import com.example.axon.demo.entity.Employee;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/employee")
public interface EmployeeController {
    @GetMapping
    List<Employee> getAllEmployee();

    @PostMapping
    ResponseEntity<ReponseObject> saveEmployee(@RequestBody EmployeeDTO employeeDTO);
    @GetMapping("/{id}")
    ResponseEntity<ReponseObject> getEmployeeById(@PathVariable Long id);
    @PutMapping("/{id}")
    ResponseEntity<ReponseObject> updateEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<ReponseObject> deleteEmployeeById(@PathVariable Long id);
    @GetMapping("/department/{id}")
    ResponseEntity<ReponseObject> getAllEmployeeByDepartmentId(@PathVariable Long id);

}
