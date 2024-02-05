package com.example.student_managment_system.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KycStudentRecordsDto {

    private int kycStuId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String schoolRegNumber;
    private String classNumber;
    private String medium;
    private String religion;
    private String parentName;
    private String parentRelation;
    private String mobileNumber;
    private String residenceNumber;
    private String address;
    private String stuPassword;

    public KycStudentRecordsDto(int kycStuId, String firstName, String lastName, String fullName, String schoolRegNumber,
                                String classNumber, String medium, String religion, String parentName, String parentRelation,
                                String mobileNumber, String residenceNumber, String address) {
        this.kycStuId = kycStuId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.schoolRegNumber = schoolRegNumber;
        this.classNumber = classNumber;
        this.medium = medium;
        this.religion = religion;
        this.parentName = parentName;
        this.parentRelation = parentRelation;
        this.mobileNumber = mobileNumber;
        this.residenceNumber = residenceNumber;
        this.address = address;
    }
}
