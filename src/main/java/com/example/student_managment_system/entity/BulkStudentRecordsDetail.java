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
public class BulkStudentRecordsDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    // One-to-one association with RegisterStudent
    @OneToOne(mappedBy = "bulkStudentRecords", cascade = CascadeType.ALL)
    private RegisterStudent registerStudent;
    private Date createdTime;
    private Date lastUpdateTime;
}
