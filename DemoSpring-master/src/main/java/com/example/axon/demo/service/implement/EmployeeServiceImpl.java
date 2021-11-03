package com.example.axon.demo.service.implement;

import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.Employee;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.repostory.DepartmentRepostory;
import com.example.axon.demo.repostory.EmployeeRepostory;
import com.example.axon.demo.service.EmployeeService;
import com.example.axon.demo.service.dto.EmployeeDTO;
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
    public List<Employee> getAllEmployee() {
        return employeeRepostory.findAll();
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
                        new ReponseObject("Save Success","Save Employee Success",employeeSave)
                );
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ReponseObject("Save Fail","Email must unique","")
                );
            }

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              new ReponseObject("Not Found","Not found Department with id " + employeeDTO.getDepartment(),"")
            );
        }
    }

    @Override
    public ResponseEntity<ReponseObject> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepostory.findById(id);
        return  employee.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ReponseObject("Found","Find Employee",employee)
                ):ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ReponseObject("Not found","Not find Employee with id = "+ id,"")
        );
    }

    @Override
    public ResponseEntity<ReponseObject> getAllEmployeeByDepartmentId(Long id) {

        Optional<Department> department = departmentRepostory.findById(id);
        if(department.isPresent()){
            List<Employee> employees = employeeRepostory.findAllEmployeeByIdDepartment(department.get());

            return employees.size()==0?ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("Not Found","Not Find Departmant","")
            ):ResponseEntity.status(HttpStatus.FOUND).body(
                    new ReponseObject("Found","Find Employee",employees)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("Not Found","not Find Employee with id deparment = "+ id,"")
            );
        }
    }

    @Override
    public ResponseEntity<ReponseObject> updateEmployee(EmployeeDTO employeeDTO,Long id) {

        Optional<Employee> employeeOld = employeeRepostory.findById(id);

        if(employeeOld.isPresent()){
            System.out.println("do 1");
            Optional<Department> department = departmentRepostory.findById(employeeDTO.getDepartment());
            if(department.isPresent()){
                System.out.println("do 2");
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
                  new ReponseObject("OK","Update Success",employeeSave)
                );
            }else{
                System.out.println("do 3");
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ReponseObject("Not Found","Not Found Department with id " + employeeDTO.getDepartment(),"")
                );
            }
        } else{
            System.out.println("do 4");
           return saveEmployee(employeeDTO);
        }
    }

    @Override
    public ResponseEntity<ReponseObject> deleteEmployeeById(Long id) {
        if(employeeRepostory.existsById(id)){
            employeeRepostory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject("ok","Delete Empoyee with id = " + id+ " success","")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("Fail","Not found Employee with " + id,"")
            );
        }
    }
}
