package com.axonactive.demo_spring.service.implement;

import com.axonactive.demo_spring.entity.Department;
import com.axonactive.demo_spring.entity.ReponseObject;
import com.axonactive.demo_spring.repostory.DepartmentRepostory;
import com.axonactive.demo_spring.service.DepartmentService;
import com.axonactive.demo_spring.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepostory departmentRepostory;
    @Override
    public ResponseEntity<ReponseObject> getAllDepartment() {
        List<Department> departmentList = departmentRepostory.findAll();
        return departmentList.size() == 0? ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Department","")
        ) : ResponseEntity.status(HttpStatus.FOUND).body(
                new ReponseObject(String.valueOf(HttpStatus.FOUND),"Found Department",departmentList)
        );
    }

    @Override
    public ResponseEntity<ReponseObject> saveDepartment(DepartmentDTO departmentDTO) {
        try {
            Department department = new Department();
            department.setName(departmentDTO.getName());
            department.setLocation(departmentDTO.getLocation());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject(String.valueOf(HttpStatus.OK),"Save success",departmentRepostory.save(department))
            );
        }catch (HttpStatusCodeException e){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ReponseObject(String.valueOf(e.getStatusCode()),"Save Fail","")
            );
        }

    }

    @Override
    public ResponseEntity<ReponseObject> getDepartmentById(Long id) {
        Optional<Department> department = departmentRepostory.findById(id);
       return  department.isPresent() ?
           ResponseEntity.status(HttpStatus.FOUND).body(
              new ReponseObject(String.valueOf(HttpStatus.FOUND),"Found Departmant",department)
            ):ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Department with id = "+ id,"")
            );
    }

    @Override
    public ResponseEntity<ReponseObject> updateDepartment(Department department) {

        try {
            Department departmentSave = new Department();
            departmentSave.setId(department.getId());
            departmentSave.setName(department.getName());
            departmentSave.setLocation(department.getLocation());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject(String.valueOf(HttpStatus.OK),"Update Success",departmentRepostory.save(departmentSave))
            );
        }catch (HttpStatusCodeException s){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ReponseObject(String.valueOf(s.getStatusCode()),"Update Fail","")
            );
        }
    }

    @Override
    public ResponseEntity<ReponseObject> deleteDepartmentById(Long id) {
        if(departmentRepostory.existsById(id)){
            departmentRepostory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject(String.valueOf(HttpStatus.OK),"Delete Department with id = " + id+ " success","")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject(String.valueOf(HttpStatus.NOT_FOUND),"Not Found Department with " + id,"")
            );
        }
    }
}
