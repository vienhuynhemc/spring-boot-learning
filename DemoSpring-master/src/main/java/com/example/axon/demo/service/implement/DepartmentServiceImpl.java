package com.example.axon.demo.service.implement;

import com.example.axon.demo.entity.Department;
import com.example.axon.demo.entity.ReponseObject;
import com.example.axon.demo.repostory.DepartmentRepostory;
import com.example.axon.demo.service.DepartmentService;
import com.example.axon.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepostory departmentRepostory;
    @Override
    public List<Department> getAllDepartment() {
        return departmentRepostory.findAll();
    }

    @Override
    public Department saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setLocation(departmentDTO.getLocation());
        return departmentRepostory.save(department);
    }

    @Override
    public ResponseEntity<ReponseObject> getDepartmentById(Long id) {
        Optional<Department> department = departmentRepostory.findById(id);
       return  department.isPresent() ?
           ResponseEntity.status(HttpStatus.OK).body(
              new ReponseObject("Found","Find Departmant",department)
            ):ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              new ReponseObject("Not found","Not find Department with id = "+ id,"")
            );
    }

    @Override
    public Department updateDepartment(Department department) {
        Department departmentOld = departmentRepostory.findById(department.getId()).map(
                departmentSave -> {
                    departmentSave.setName(department.getName());
                    departmentSave.setLocation(department.getLocation());
                    return departmentRepostory.save(departmentSave);
                }).orElseGet(() -> {
                    return departmentRepostory.save(department);
        });
        return department;
    }

    @Override
    public ResponseEntity<ReponseObject> deleteDepartmentById(Long id) {
        if(departmentRepostory.existsById(id)){
            departmentRepostory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject("ok","Delete Department with id = " + id+ " success","")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("Fail","Not found Department with " + id,"")
            );
        }
    }
}
