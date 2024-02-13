package com.example.student_managment_system.controller;

import com.example.student_managment_system.service.FireBaseStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/firebase-image")
public class FireBaseImageUploadController {

    private final FireBaseStorageService fireBaseStorageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImageToFirebaseStorage(@RequestParam("file") MultipartFile multipartFile){
        return ResponseEntity.ok(fireBaseStorageService.uploadImage(multipartFile));
    }


}
