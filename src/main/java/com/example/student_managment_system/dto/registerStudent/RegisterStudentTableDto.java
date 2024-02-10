package com.example.student_managment_system.dto.registerStudent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStudentTableDto {

    private int regStudId;
    private String classStudy;
    private String studentStatus;
    private String studentName;

}
