package com.axonactive.demo_spring.service;

import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<ReponseObject> getAllEmployee();
    ResponseEntity<ReponseObject> saveEmployee(EmployeeDTO employeeDTO);
    ResponseEntity<ReponseObject> getEmployeeById(Long id);
    ResponseEntity<ReponseObject> getAllEmployeeByDepartmentId(Long id);
    ResponseEntity<ReponseObject> updateEmployee(EmployeeDTO employeeDTO,Long id);
    ResponseEntity<ReponseObject> deleteEmployeeById(Long id);

}
