package com.example.student_managment_system.controller;

import com.example.student_managment_system.dto.RegisterStudentDto;
import com.example.student_managment_system.dto.registerStudent.RegisterStudentTableDto;
import com.example.student_managment_system.service.RegisterStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register-student")
public class RegisterStudentController {

    private final RegisterStudentService registerStudentService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterStudentDto> saveRegisterStudentDetails(@RequestBody RegisterStudentDto registerStudentDto){
        return ResponseEntity.ok(registerStudentService.saveRegisterStudentDetails(registerStudentDto));
    }

    @GetMapping
    public ResponseEntity<List<RegisterStudentTableDto>> getAllRegisterStudentDetails(){
        return ResponseEntity.ok(registerStudentService.getAllStudentRecordDetails());
    }
}
