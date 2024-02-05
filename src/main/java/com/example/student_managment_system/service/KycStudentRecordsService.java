package com.example.student_managment_system.service;

import com.example.student_managment_system.dto.KycStudentRecordsDto;

import java.util.List;

public interface KycStudentRecordsService {

    KycStudentRecordsDto saveKycStudentRecordsDetail(KycStudentRecordsDto kycStudentRecordsDto);

    KycStudentRecordsDto updateKycStudentRecordsDetail(KycStudentRecordsDto kycStudentRecordsDto);

    String deleteKycStudentRecordsDetail(Integer bulkStuId);

    KycStudentRecordsDto getKycStudentRecordsDetailByStuRegNumber(String stuRegNumber);

    List<KycStudentRecordsDto> getAllKycStudentRecordsDetail();

}
