package com.example.student_managment_system.service;

import com.example.student_managment_system.dto.RegisterStudentDto;
import com.example.student_managment_system.dto.registerStudent.RegisterStudentTableDto;

import java.util.List;

public interface RegisterStudentService {

    RegisterStudentDto saveRegisterStudentDetails(RegisterStudentDto registerStudentDto);

    List<RegisterStudentTableDto> getAllStudentRecordDetails();

}
