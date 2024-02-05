package com.example.student_managment_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KycStudentRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    // One-to-one association with RegisterStudent
    @OneToOne(mappedBy = "kycStudentRecords", cascade = CascadeType.ALL)
    private RegisterStudent registerStudent;
    private Date createdTime;
    private Date lastUpdateTime;

}
