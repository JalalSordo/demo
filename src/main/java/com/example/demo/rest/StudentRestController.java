package com.example.demo.rest;

import com.example.demo.data.Student;
import com.example.demo.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Implements {@link some class}<br>
 * Some class description <br>
 *
 * @author Jalal Sordo
 * @since 23-Oct-23
 */

@RestController
@RequestMapping("/students")
public class StudentRestController {


    private StudentRepository studentRepository;

    @Autowired
    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable("id") String id) {
        return studentRepository.findById(Long.valueOf(id));

    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> student.setPhone("123456789"));
        return students;

    }

    @PostMapping
    public Student savePerson(@RequestBody Student student) {
        return studentRepository.save(student);

    }

}
