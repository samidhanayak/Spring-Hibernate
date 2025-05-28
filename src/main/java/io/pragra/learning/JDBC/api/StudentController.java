package io.pragra.learning.JDBC.api;

import io.pragra.learning.JDBC.entities.Student;
import io.pragra.learning.JDBC.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudents();
        return students;
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student updated = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updated);
    }
}
