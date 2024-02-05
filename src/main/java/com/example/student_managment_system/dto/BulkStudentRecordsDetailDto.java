package com.example.student_managment_system.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BulkStudentRecordsDetailDto {

    private int bulkStuId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String schoolRegNumber;
    private String className;
    private String medium;
    private String religion;
    private String parentName;
    private String parentRelation;
    private String mobileNumber;
    private String residenceNumber;
    private String address;

}

