package com.axonactive.demo_spring.controller;

import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
public interface EmployeeController {
    @GetMapping
    ResponseEntity<ReponseObject> getAllEmployee();

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
