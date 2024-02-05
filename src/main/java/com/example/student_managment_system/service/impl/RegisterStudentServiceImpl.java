package com.example.student_managment_system.service.impl;

import com.example.student_managment_system.dto.RegisterStudentDto;
import com.example.student_managment_system.repository.RegisterStudentRepository;
import com.example.student_managment_system.service.RegisterStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterStudentServiceImpl implements RegisterStudentService {

    private final RegisterStudentRepository registerStudentRepository;

    @Override
    public RegisterStudentDto saveRegisterStudentDetails(RegisterStudentDto registerStudentDto) {
        return null;
    }
}
