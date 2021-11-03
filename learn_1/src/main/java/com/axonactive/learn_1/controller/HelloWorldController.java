package com.axonactive.learn_1.controller;


import com.axonactive.learn_1.entity.Student;
import com.axonactive.learn_1.service.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "abc/v1")
public interface HelloWorldController {

    @GetMapping
    List<Student> hello();

    @PostMapping
    Student saveStudent(@RequestBody StudentDTO studentDTO);

    @DeleteMapping(path = "/{sId}")
    Student deleteStudent(@PathVariable("sId") Long id);

    @PutMapping(path = "/{sId}")
    Student updateStudent(
            @PathVariable("sId") Long id,
            @RequestParam(required = false) Integer age
            );

    @PutMapping(path = "/{sId}/{age}")
    Student updateStudentFull(
            @PathVariable("sId") Long id,
            @PathVariable("age") Integer age
    );
}
