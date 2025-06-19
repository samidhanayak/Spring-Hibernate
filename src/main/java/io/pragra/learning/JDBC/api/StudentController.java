package io.pragra.learning.JDBC.api;

import io.pragra.learning.JDBC.entities.Student;
import io.pragra.learning.JDBC.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/byId")
    public Optional<Student> getById(@RequestParam("id") Integer identification){
        Optional<Student> studentById = studentService.getStudentById(identification);

        return studentById;
    }
    @GetMapping("/byId/{id}")
    public Optional<Student> getByIdInPath(@PathVariable("id") Integer id){
        Optional<Student> studentById = studentService.getStudentById(id);

        return studentById;
    }

//    @PostMapping("/create")
//    public Student createStudent(@RequestBody Student student){
//        return studentService.createStudent(student);
//    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentEntity = studentService.createStudent(student);
        ResponseEntity<Student> studentResponseEntity = ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .header("Action", "Created")
                .header("GenId", String.valueOf(studentEntity.getId()))
                .header("status", String.valueOf(1100))
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentEntity);
        return studentResponseEntity;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @PatchMapping("/patch")
    public Student patch(@RequestBody Student student){
        return studentService.patchUpdate(student);
    }

    @GetMapping("/allByName")
    public List<Student> getAllByFirstName(@RequestParam String name){
        return studentService.getAllByFirstName(name);
    }

}
