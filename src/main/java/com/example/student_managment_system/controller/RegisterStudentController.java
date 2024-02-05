package com.example.student_managment_system.controller;

import com.example.student_managment_system.dto.RegisterStudentDto;
import com.example.student_managment_system.service.RegisterStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register-student")
public class RegisterStudentController {

    private final RegisterStudentService registerStudentService;

    @PostMapping("/save")
    public ResponseEntity<RegisterStudentDto> saveRegisterStudentDetails(@RequestBody RegisterStudentDto registerStudentDto){
        return ResponseEntity.ok(registerStudentService.saveRegisterStudentDetails(registerStudentDto));
    }
}
