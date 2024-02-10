package com.example.student_managment_system.service.impl;

import com.example.student_managment_system.dto.BulkStudentRecordsDetailDto;
import com.example.student_managment_system.dto.KycStudentRecordsDto;
import com.example.student_managment_system.dto.RegisterStudentDto;
import com.example.student_managment_system.dto.registerStudent.RegisterStudentTableDto;
import com.example.student_managment_system.entity.BulkStudentRecordsDetail;
import com.example.student_managment_system.entity.KycStudentRecords;
import com.example.student_managment_system.entity.RegisterStudent;
import com.example.student_managment_system.repository.BulkStudentRecordsDetailRepository;
import com.example.student_managment_system.repository.KycStudentRecordsRepository;
import com.example.student_managment_system.repository.RegisterStudentRepository;
import com.example.student_managment_system.service.RegisterStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RegisterStudentServiceImpl implements RegisterStudentService {

    private final KycStudentRecordsRepository kycStudentRecordsRepository;
    private final BulkStudentRecordsDetailRepository bulkStudentRecordsDetailRepository;
    private final RegisterStudentRepository registerStudentRepository;

    @Override
    public RegisterStudentDto saveRegisterStudentDetails(RegisterStudentDto registerStudentDto) {
        RegisterStudent registerStudent = new RegisterStudent();
        BeanUtils.copyProperties(registerStudentDto,registerStudent);
        KycStudentRecords kycStudentRecords = kycStudentRecordsRepository.findById(registerStudentDto.getKycStudentRecords().getKycStuId()).orElseThrow(() -> {
            throw new RuntimeException("Kyc Record Is Not Found");
        });
        BulkStudentRecordsDetail bulkStudentRecordsDetail = bulkStudentRecordsDetailRepository.findById(registerStudentDto.getBulkStudentRecords().getBulkStuId()).orElseThrow(() -> {
            throw new RuntimeException("Bulk Record Is Not Found");
        });
        registerStudent.setKycStudentRecords(kycStudentRecords);
        registerStudent.setBulkStudentRecords(bulkStudentRecordsDetail);
        registerStudent.setCreatedTime(new Date());
        RegisterStudent saveRegisterStudent = registerStudentRepository.save(registerStudent);
        return RegisterStudentDto.builder().registerStuId(saveRegisterStudent.getRegisterStuId())
                .kycStudentRecords(formatToKycRecordsDto(saveRegisterStudent.getKycStudentRecords()))
                .bulkStudentRecords(formatToBulkRecordsDto(saveRegisterStudent.getBulkStudentRecords()))
                .status(saveRegisterStudent.getStatus())
                .teacherDescription(saveRegisterStudent.getTeacherDescription()).build();
    }

    @Override
    public List<RegisterStudentTableDto> getAllStudentRecordDetails() {
        return registerStudentRepository.findAllRegisterStudentsDetails();
    }

    private KycStudentRecordsDto formatToKycRecordsDto(KycStudentRecords kycStudentRecords){
        KycStudentRecordsDto kycStudentRecordsDto = new KycStudentRecordsDto();
        BeanUtils.copyProperties(kycStudentRecordsDto,kycStudentRecords);
        return kycStudentRecordsDto;
    }

    private BulkStudentRecordsDetailDto formatToBulkRecordsDto(BulkStudentRecordsDetail kycStudentRecords){
        BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto = new BulkStudentRecordsDetailDto();
        BeanUtils.copyProperties(kycStudentRecords,bulkStudentRecordsDetailDto);
        return bulkStudentRecordsDetailDto;
    }
}
