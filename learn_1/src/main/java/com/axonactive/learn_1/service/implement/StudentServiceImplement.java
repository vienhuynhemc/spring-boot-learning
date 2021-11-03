package com.axonactive.learn_1.service.implement;

import com.axonactive.learn_1.entity.Student;
import com.axonactive.learn_1.repository.StudentRepository;
import com.axonactive.learn_1.service.StudentService;
import com.axonactive.learn_1.service.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> hello() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentDTO.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email da ton tai");
        }
        Student student = new Student();
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        student.setName(studentDTO.getName());
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("not exist");
        }
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new IllegalStateException("");
        }
        studentRepository.deleteById(id);
        return student.get();
    }

    @Override
    public Student updateStudent(Long id, Integer age) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            throw new IllegalStateException("not exist");
        }
        Student student = optionalStudent.get();
        if(age != null ){
            student.setAge(age);
        }
        studentRepository.save(student);
        return student;
    }

}
