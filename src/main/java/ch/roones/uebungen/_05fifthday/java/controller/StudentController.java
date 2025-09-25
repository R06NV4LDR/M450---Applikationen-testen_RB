package ch.roones.uebungen._05fifthday.java.controller;

import ch.roones.uebungen._05fifthday.java.repository.StudentRepository;
import ch.roones.uebungen._05fifthday.java.repository.entities.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @PostMapping("/students")
    void addStudent(@RequestBody Student user) {
        studentRepository.save(user);
    }

}
