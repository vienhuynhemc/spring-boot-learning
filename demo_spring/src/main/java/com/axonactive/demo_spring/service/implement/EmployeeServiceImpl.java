package com.axonactive.demo_spring.service.implement;

import com.axonactive.demo_spring.entity.Department;
import com.axonactive.demo_spring.entity.Employee;
import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.repostory.DepartmentRepostory;
import com.axonactive.demo_spring.repostory.EmployeeRepostory;
import com.axonactive.demo_spring.service.EmployeeService;
import com.axonactive.demo_spring.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepostory employeeRepostory;
    private final DepartmentRepostory departmentRepostory;

    @Override
    public ResponseEntity<ReponseObject> getAllEmployee() {
        List<Employee> employees = employeeRepostory.findAll();
        return employees.size() == 0? ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Employee","")
        ) : ResponseEntity.status(HttpStatus.FOUND).body(
                new ReponseObject(String.valueOf(HttpStatus.FOUND),"Found Employee",employees)
        );
    }

    @Override
    public ResponseEntity<ReponseObject> saveEmployee(EmployeeDTO employeeDTO) {

        Optional<Department> department = departmentRepostory.findById(employeeDTO.getDepartment());

        if (department.isPresent()){
            try {
                Employee employee = new Employee();
                employee.setFirstName(employeeDTO.getFirstName());
                employee.setLastName(employeeDTO.getLastName());
                employee.setAddress(employeeDTO.getAddress());
                employee.setGender(employeeDTO.getGender());
                employee.setEmail(employeeDTO.getEmail());
                employee.setCity(employeeDTO.getCity());
                employee.setDepartment(department.get());
                employee.setDoB(employeeDTO.getDoB());
                Employee employeeSave = employeeRepostory.save(employee);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ReponseObject(String.valueOf(HttpStatus.OK),"Save Employee Success",employeeSave)
                );
            }catch (Exception exception){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        new ReponseObject(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR),exception.getMessage(),"")
                );
            }

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Department with id " + employeeDTO.getDepartment(),"")
            );
        }
    }

    @Override
    public ResponseEntity<ReponseObject> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepostory.findById(id);
        return  employee.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ReponseObject(String.valueOf(HttpStatus.OK),"Found Employee",employee)
                ):ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Employee with id = "+ id,"")
        );
    }

    @Override
    public ResponseEntity<ReponseObject> getAllEmployeeByDepartmentId(Long id) {

        Optional<Department> department = departmentRepostory.findById(id);
        if(department.isPresent()){
            List<Employee> employees = employeeRepostory.findAllEmployeeByIdDepartment(department.get());

            return employees.size()==0?ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Departmant","")
            ):ResponseEntity.status(HttpStatus.FOUND).body(
                    new ReponseObject(String.valueOf(HttpStatus.FOUND),"Found Employee",employees)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"not Found Employee with id deparment = "+ id,"")
            );
        }
    }

    @Override
    public ResponseEntity<ReponseObject> updateEmployee(EmployeeDTO employeeDTO,Long id) {

        Optional<Employee> employeeOld = employeeRepostory.findById(id);

        if(employeeOld.isPresent()){
            Optional<Department> department = departmentRepostory.findById(employeeDTO.getDepartment());
            if(department.isPresent()){
                Employee employeeSave = new Employee();
                employeeSave.setId(id);
                employeeSave.setFirstName(employeeDTO.getFirstName());
                employeeSave.setLastName(employeeDTO.getLastName());
                employeeSave.setEmail(employeeDTO.getEmail());
                employeeSave.setGender(employeeDTO.getGender());
                employeeSave.setCity(employeeDTO.getCity());
                employeeSave.setDepartment(department.get());
                employeeSave.setAddress(employeeDTO.getAddress());
                employeeSave.setDoB(employeeDTO.getDoB());
                employeeRepostory.save(employeeSave);
                return ResponseEntity.status(HttpStatus.OK).body(
                  new ReponseObject(String.valueOf(HttpStatus.OK),"Update Success",employeeSave)
                );
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Department with id " + employeeDTO.getDepartment(),"")
                );
            }
        } else{
           return saveEmployee(employeeDTO);
        }
    }

    @Override
    public ResponseEntity<ReponseObject> deleteEmployeeById(Long id) {
        if(employeeRepostory.existsById(id)){
            employeeRepostory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject(String.valueOf(HttpStatus.OK),"Delete Empoyee with id = " + id+ " success","")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not found Employee with " + id,"")
            );
        }
    }
}
