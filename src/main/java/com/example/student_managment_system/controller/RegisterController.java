package com.example.student_managment_system.controller;

import com.example.student_managment_system.dto.UserDto;
import com.example.student_managment_system.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        if (null != userDto) {
            UserDto registerUser = registerService.registerUser(userDto);
            if (null != registerUser){
                return ResponseEntity.ok(registerUser);
            }
            return ResponseEntity.internalServerError().body("Something Went Wrong!!!");
        }
        return ResponseEntity.badRequest().body("Object Can't be empty");
    }

}
