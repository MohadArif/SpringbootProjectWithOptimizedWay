package com.StudentErp.project.service;

import com.StudentErp.project.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    public void createStudent(Student student);

    public List<Student> fetchAllStudents();

    public Student findStudentById(Long id);

    public void deleteById(Long id);

    public Student updateById(Student student);

    public void uploadImage(MultipartFile file) throws IOException;
}
