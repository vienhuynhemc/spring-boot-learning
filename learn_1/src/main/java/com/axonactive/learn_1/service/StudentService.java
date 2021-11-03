package com.axonactive.learn_1.service;

import com.axonactive.learn_1.entity.Student;
import com.axonactive.learn_1.service.dto.StudentDTO;

import java.util.List;


public interface StudentService {

    List<Student> hello();

    Student saveStudent(StudentDTO studentDTO);

    Student deleteStudent(Long id);

    Student updateStudent(Long id, Integer age);
}
