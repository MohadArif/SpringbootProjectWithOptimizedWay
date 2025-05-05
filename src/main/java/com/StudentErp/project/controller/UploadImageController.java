package com.StudentErp.project.controller;

import com.StudentErp.project.service.UploadImageService;
import com.StudentErp.project.serviceImpl.UploadImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api")
public class UploadImageController {


    private final UploadImageService uploadImageService;

    public UploadImageController(UploadImageService uploadImageService) {
        this.uploadImageService = uploadImageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImages(@RequestParam MultipartFile file) throws IOException {
        uploadImageService.uploadImage(file);
        return new ResponseEntity<>("file upload successfully !!", HttpStatus.OK);
    }
}
