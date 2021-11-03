package com.axonactive.learn_1.controller.implement;

import com.axonactive.learn_1.controller.HelloWorldController;
import com.axonactive.learn_1.entity.Student;
import com.axonactive.learn_1.service.StudentService;
import com.axonactive.learn_1.service.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloWorldControllerImplement implements HelloWorldController {

    private final StudentService studentService;

    @Override
    public List<Student> hello() {
        return studentService.hello();
    }

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @Override
    public Student deleteStudent(Long id) {
        return studentService.deleteStudent(id);
    }

    @Override
    public Student updateStudent(Long id, Integer age) {
        return studentService.updateStudent(id,age);
    }

    @Override
    public Student updateStudentFull(Long id, Integer age) {
        return studentService.updateStudent(id,age);
    }
}
