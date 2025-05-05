package com.StudentErp.project.serviceImpl;

import com.StudentErp.project.entity.Student;
import com.StudentErp.project.exceptionhandler.StudentNotFoundException;
import com.StudentErp.project.repository.StudentRepository;
import com.StudentErp.project.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@Log4j2
public class StudentServiceImpl implements StudentService {

//    private static final Logger logging= LoggerFactory.getLogger(StudentServiceImpl.class);  //

//    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {
        log.info("student details save successfully!!");
      studentRepository.save(student);
    }

    @Override
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        log.error(id+" not found !!");
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id+"not found!!"));
    }

    @Override
    public void deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("sorry not found!!"));
//        studentRepository.deleteById(student.getId());
        studentRepository.delete(student);      //more optimized
    }

    @Override
    @Transactional
    public Student updateById(Student student) {
        Student existingStudent = findStudentById(student.getId());
        existingStudent.setStdName(student.getStdName());
        existingStudent.setStdCity(student.getStdCity());
        existingStudent.setStdMob(student.getStdMob());
        existingStudent.setStdState(student.getStdState());
        return studentRepository.save(existingStudent);

//        this is optimized way in this  case if client sent few fields then
//        it will update that field only if it is not null.

//        When I used this senario.I have send few fields then it  update
//        that particuler field only and rest of the filed update as null
//        becasue it got overridde so pervent this we should use DTO's
//        and PATCH method for update.

//            Student existingStudent = findStudentById(student.getId());
//
//            if (student.getStdName() != null) {
//                existingStudent.setStdName(student.getStdName());
//            }
//            if (student.getStdCity() != null) {
//                existingStudent.setStdCity(student.getStdCity());
//            }
//            if (student.getStdMob() != null) {
//                existingStudent.setStdMob(student.getStdMob());
//            }
//            if (student.getStdState() != null) {
//                existingStudent.setStdState(student.getStdState());
//            }
//
//            return studentRepository.save(existingStudent);
        }

    @Override
    public void uploadImage(MultipartFile file) throws IOException {
        String path="ImageFolder/";
        String name=file.getOriginalFilename();
        File directery=new File(path);
        if(!directery.exists()){
            directery.mkdirs();
        }

        Path loction=new File(directery,name).toPath();
        Files.createFile(loction);
    }

}
