package com.example.student_managment_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registerStuId;
    @OneToOne
    @JoinColumn(name = "kycStuId", referencedColumnName = "kycStuId")
    private KycStudentRecords kycStudentRecords;
    @OneToOne
    @JoinColumn(name = "bulkStuId", referencedColumnName = "bulkStuId")
    private BulkStudentRecordsDetail bulkStudentRecords;
    private String status;
    private String teacherDescription;
    private Date createdTime;
    private Date lastUpdateTime;

}
