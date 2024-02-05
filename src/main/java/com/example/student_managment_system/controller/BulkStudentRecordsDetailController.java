package com.example.student_managment_system.controller;

import com.example.student_managment_system.dto.BulkStudentRecordsDetailDto;
import com.example.student_managment_system.service.BulkStudentRecordsDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bulk-student-records")
public class BulkStudentRecordsDetailController {

    private final BulkStudentRecordsDetailService bulkStudentRecordsDetailService;

    @GetMapping
    public ResponseEntity<List<BulkStudentRecordsDetailDto>> getAllBulkStudentRecordsDetails(){
        return ResponseEntity.ok(bulkStudentRecordsDetailService.getAllBulkStudentRecordDetails());
    }

    @PostMapping("/save")
    public ResponseEntity<BulkStudentRecordsDetailDto> saveBulkStudentRecords(@RequestBody BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto) {
        return ResponseEntity.ok(bulkStudentRecordsDetailService.saveBulkStudentRecordsDetail(bulkStudentRecordsDetailDto));
    }

    @PutMapping("/update")
    public ResponseEntity<BulkStudentRecordsDetailDto> updateBulkStudentRecords(@RequestBody BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto) {
        return ResponseEntity.ok(bulkStudentRecordsDetailService.updateBulkStudentRecordsDetail(bulkStudentRecordsDetailDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBulkStudentRecords(@RequestParam Integer bulkStuId) {
        return ResponseEntity.ok(bulkStudentRecordsDetailService.deleteBulkStudentRecordsDetail(bulkStuId));
    }

    @GetMapping("/stuId")
    public ResponseEntity<BulkStudentRecordsDetailDto> getBulkStudentRecordsDetails(@RequestParam String stuRegNumber) {
        return ResponseEntity.ok(bulkStudentRecordsDetailService.getBulkStudentRecordsDetailByStuRegNumber(stuRegNumber));
    }


}
