package com.StudentErp.project.serviceImpl;

import com.StudentErp.project.entity.UploadImages;
import com.StudentErp.project.repository.UploadImageRepository;
import com.StudentErp.project.service.UploadImageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Log4j2
public class UploadImageServiceImpl implements UploadImageService {


    private final UploadImageRepository uploadImageRepository;

    public UploadImageServiceImpl(UploadImageRepository uploadImageRepository) {
        this.uploadImageRepository = uploadImageRepository;
    }

    @Override
    public void uploadImage(MultipartFile file) throws IOException {
        log.info("file uploaded ...");
        uploadImageRepository.save(UploadImages.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes()).build());
    }
}
