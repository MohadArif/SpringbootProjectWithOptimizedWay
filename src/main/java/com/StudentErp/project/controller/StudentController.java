package com.StudentErp.project.controller;

import com.StudentErp.project.entity.Student;
import com.StudentErp.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/apis")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok().body("student created!!");
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok().body(studentService.fetchAllStudents());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id){
        return ResponseEntity.ok().body(studentService.findStudentById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudentDetails(@RequestBody Student student){
        Student updatedStudent = studentService.updateById(student);
        return ResponseEntity.ok().body(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile file) throws IOException {
//        studentService.uploadImage(file);
//        return new ResponseEntity<String>("image upload successfully",HttpStatus.OK);
//    }
}
