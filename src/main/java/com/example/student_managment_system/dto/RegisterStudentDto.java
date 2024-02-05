package com.example.student_managment_system.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStudentDto {

    private int registerStuId;
    private KycStudentRecordsDto kycStudentRecords;
    private BulkStudentRecordsDetailDto bulkStudentRecords;
    private String status;
    private String teacherDescription;

}
