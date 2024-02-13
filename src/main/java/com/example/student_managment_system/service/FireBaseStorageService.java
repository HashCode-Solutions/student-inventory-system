package com.example.student_managment_system.service;

import org.springframework.web.multipart.MultipartFile;

public interface FireBaseStorageService {

    String uploadImage(MultipartFile multipartFile);

}
