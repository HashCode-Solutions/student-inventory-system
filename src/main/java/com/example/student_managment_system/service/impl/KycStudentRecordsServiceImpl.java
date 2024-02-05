package com.example.student_managment_system.service.impl;

import com.example.student_managment_system.dto.KycStudentRecordsDto;
import com.example.student_managment_system.entity.KycStudentRecords;
import com.example.student_managment_system.repository.KycStudentRecordsRepository;
import com.example.student_managment_system.service.KycStudentRecordsService;
import com.example.student_managment_system.utils.AESUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class KycStudentRecordsServiceImpl implements KycStudentRecordsService {

    private static final String SECRET_KEY = "secrete";
    private final KycStudentRecordsRepository kycStudentRecordsRepository;

    @Override
    public KycStudentRecordsDto saveKycStudentRecordsDetail(KycStudentRecordsDto kycStudentRecordsDto) {
        KycStudentRecords kycStudentRecords = new KycStudentRecords();
        BeanUtils.copyProperties(kycStudentRecordsDto, kycStudentRecords);
        kycStudentRecords.setCreatedTime(new Date());
        kycStudentRecords.setStuPassword(AESUtils.encrypt(kycStudentRecordsDto.getStuPassword(), SECRET_KEY));
        KycStudentRecords saveKycStudentRecords = kycStudentRecordsRepository.save(kycStudentRecords);
        return KycStudentRecordsDto.builder().kycStuId(saveKycStudentRecords.getKycStuId())
                .firstName(saveKycStudentRecords.getFirstName()).lastName(saveKycStudentRecords.getLastName())
                .fullName(saveKycStudentRecords.getFullName()).schoolRegNumber(saveKycStudentRecords.getSchoolRegNumber())
                .classNumber(saveKycStudentRecords.getClassNumber()).medium(saveKycStudentRecords.getMedium())
                .religion(saveKycStudentRecords.getReligion()).parentName(saveKycStudentRecords.getParentName())
                .parentRelation(saveKycStudentRecords.getParentRelation()).mobileNumber(saveKycStudentRecords.getMobileNumber())
                .residenceNumber(saveKycStudentRecords.getResidenceNumber()).address(saveKycStudentRecords.getAddress())
                .stuPassword(AESUtils.decrypt(saveKycStudentRecords.getStuPassword(), SECRET_KEY)).build();
    }

    @Override
    public KycStudentRecordsDto updateKycStudentRecordsDetail(KycStudentRecordsDto kycStudentRecordsDto) {
        return null;
    }

    @Override
    public String deleteKycStudentRecordsDetail(Integer bulkStuId) {
        return null;
    }

    @Override
    public KycStudentRecordsDto getKycStudentRecordsDetailByStuRegNumber(String stuRegNumber) {
        return null;
    }

    @Override
    public List<KycStudentRecordsDto> getAllKycStudentRecordsDetail() {
        return kycStudentRecordsRepository.findAllKycStudentRecordsDetails();
    }
}
