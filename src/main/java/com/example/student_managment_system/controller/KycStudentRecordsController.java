package com.example.student_managment_system.controller;

import com.example.student_managment_system.dto.KycStudentRecordsDto;
import com.example.student_managment_system.service.KycStudentRecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kyc-student-records")
public class KycStudentRecordsController {

    private final KycStudentRecordsService kycStudentRecordsService;

    @GetMapping
    public ResponseEntity<List<KycStudentRecordsDto>> getAllKycStudentRecordsDetails() {
        return ResponseEntity.ok(kycStudentRecordsService.getAllKycStudentRecordsDetail());
    }

    @PostMapping("/save")
    public ResponseEntity<KycStudentRecordsDto> saveKycStudentRecords(@RequestBody KycStudentRecordsDto kycStudentRecordsDto) {
        return ResponseEntity.ok(kycStudentRecordsService.saveKycStudentRecordsDetail(kycStudentRecordsDto));
    }

    @PutMapping("/update")
    public ResponseEntity<KycStudentRecordsDto> updateKycStudentRecords(@RequestBody KycStudentRecordsDto kycStudentRecordsDto) {
        return ResponseEntity.ok(kycStudentRecordsService.updateKycStudentRecordsDetail(kycStudentRecordsDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteKycStudentRecords(@RequestParam Integer kycStuId) {
        return ResponseEntity.ok(kycStudentRecordsService.deleteKycStudentRecordsDetail(kycStuId));
    }

    @GetMapping("/stuId")
    public ResponseEntity<KycStudentRecordsDto> getKycStudentRecordsDetails(@RequestParam String stuRegNumber) {
        return ResponseEntity.ok(kycStudentRecordsService.getKycStudentRecordsDetailByStuRegNumber(stuRegNumber));
    }

}
