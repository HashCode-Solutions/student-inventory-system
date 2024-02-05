package com.example.student_managment_system.service;

import com.example.student_managment_system.dto.BulkStudentRecordsDetailDto;

import java.util.List;

public interface BulkStudentRecordsDetailService {

    BulkStudentRecordsDetailDto saveBulkStudentRecordsDetail(BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto);

    BulkStudentRecordsDetailDto updateBulkStudentRecordsDetail(BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto);

    String deleteBulkStudentRecordsDetail(Integer bulkStuId);

    BulkStudentRecordsDetailDto getBulkStudentRecordsDetailByStuRegNumber(String stuRegNumber);

    List<BulkStudentRecordsDetailDto> getAllBulkStudentRecordDetails();

}
