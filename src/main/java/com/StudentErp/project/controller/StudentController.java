package com.StudentErp.project.controller;

import com.StudentErp.project.entity.Student;
import com.StudentErp.project.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@Tag(name = "Student Controller")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    @Operation(summary = "create student end-point")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok().body("student created!!");
    }

    @GetMapping("/findAll")
    @Operation(summary = "GetAll student end-point")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok().body(studentService.fetchAllStudents());
    }

    @GetMapping("/findById/{id}")
    @Operation(summary = "find student by id end-point")
    public ResponseEntity<?> findStudentById(@PathVariable Long id){
        return ResponseEntity.ok().body(studentService.findStudentById(id));
    }

    @PutMapping("/update")
    @Operation(summary = "update student end-point")
    public ResponseEntity<?> updateStudentDetails(@RequestBody Student student){
        Student updatedStudent = studentService.updateById(student);
        return ResponseEntity.ok().body(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete student by id end-point")
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
