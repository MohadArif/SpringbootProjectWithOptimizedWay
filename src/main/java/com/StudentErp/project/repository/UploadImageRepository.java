package com.StudentErp.project.repository;

import com.StudentErp.project.entity.UploadImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UploadImageRepository extends JpaRepository<UploadImages,Long> {
    
}
