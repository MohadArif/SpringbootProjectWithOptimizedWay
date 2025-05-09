package com.StudentErp.project.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadImageService {

    public void uploadImage(MultipartFile file) throws IOException;

//    public byte[] fetchImage(String name);
}

