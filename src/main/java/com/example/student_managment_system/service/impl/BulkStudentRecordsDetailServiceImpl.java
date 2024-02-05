package com.example.student_managment_system.service.impl;

import com.example.student_managment_system.dto.BulkStudentRecordsDetailDto;
import com.example.student_managment_system.entity.BulkStudentRecordsDetail;
import com.example.student_managment_system.repository.BulkStudentRecordsDetailRepository;
import com.example.student_managment_system.service.BulkStudentRecordsDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BulkStudentRecordsDetailServiceImpl implements BulkStudentRecordsDetailService {

    private final BulkStudentRecordsDetailRepository bulkStudentRecordsDetailRepository;


    @Override
    public BulkStudentRecordsDetailDto saveBulkStudentRecordsDetail(BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto) {

        BulkStudentRecordsDetail bulkStudentRecordsDetail = new BulkStudentRecordsDetail();

        BeanUtils.copyProperties(bulkStudentRecordsDetailDto, bulkStudentRecordsDetail);

        bulkStudentRecordsDetail.setCreatedTime(new Date());

        BulkStudentRecordsDetail saveStudentRecordsDetail = bulkStudentRecordsDetailRepository.save(bulkStudentRecordsDetail);

        return BulkStudentRecordsDetailDto.builder()
                .firstName(saveStudentRecordsDetail.getFirstName()).lastName(saveStudentRecordsDetail.getLastName())
                .fullName(saveStudentRecordsDetail.getFullName()).schoolRegNumber(saveStudentRecordsDetail.getSchoolRegNumber())
                .className(saveStudentRecordsDetail.getClassName()).medium(saveStudentRecordsDetail.getMedium())
                .religion(saveStudentRecordsDetail.getReligion()).parentName(saveStudentRecordsDetail.getParentName())
                .parentRelation(saveStudentRecordsDetail.getParentRelation())
                .mobileNumber(saveStudentRecordsDetail.getMobileNumber())
                .residenceNumber(saveStudentRecordsDetail.getResidenceNumber())
                .address(saveStudentRecordsDetail.getAddress()).build();
    }

    @Override
    public BulkStudentRecordsDetailDto updateBulkStudentRecordsDetail(BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto) {
        BulkStudentRecordsDetail existBulkStudentRecordsDetail = bulkStudentRecordsDetailRepository.findById(bulkStudentRecordsDetailDto.getBulkStuId())
                .orElseThrow(() -> new RuntimeException("Not Found!!"));

        existBulkStudentRecordsDetail.setFirstName(bulkStudentRecordsDetailDto.getFirstName());
        existBulkStudentRecordsDetail.setLastName(bulkStudentRecordsDetailDto.getLastName());
        existBulkStudentRecordsDetail.setFullName(bulkStudentRecordsDetailDto.getFullName());
        existBulkStudentRecordsDetail.setSchoolRegNumber(bulkStudentRecordsDetailDto.getSchoolRegNumber());
        existBulkStudentRecordsDetail.setClassName(bulkStudentRecordsDetailDto.getClassName());
        existBulkStudentRecordsDetail.setMedium(bulkStudentRecordsDetailDto.getMedium());
        existBulkStudentRecordsDetail.setReligion(bulkStudentRecordsDetailDto.getReligion());
        existBulkStudentRecordsDetail.setParentName(bulkStudentRecordsDetailDto.getParentName());
        existBulkStudentRecordsDetail.setParentRelation(bulkStudentRecordsDetailDto.getParentRelation());
        existBulkStudentRecordsDetail.setMobileNumber(bulkStudentRecordsDetailDto.getMobileNumber());
        existBulkStudentRecordsDetail.setResidenceNumber(bulkStudentRecordsDetailDto.getResidenceNumber());
        existBulkStudentRecordsDetail.setAddress(bulkStudentRecordsDetailDto.getAddress());
        existBulkStudentRecordsDetail.setLastUpdateTime(new Date());

        BulkStudentRecordsDetail updateStudentRecordsDetail = bulkStudentRecordsDetailRepository.save(existBulkStudentRecordsDetail);

        return BulkStudentRecordsDetailDto.builder()
                .firstName(updateStudentRecordsDetail.getFirstName()).lastName(updateStudentRecordsDetail.getLastName())
                .fullName(updateStudentRecordsDetail.getFullName()).schoolRegNumber(updateStudentRecordsDetail.getSchoolRegNumber())
                .className(updateStudentRecordsDetail.getClassName()).medium(updateStudentRecordsDetail.getMedium())
                .religion(updateStudentRecordsDetail.getReligion()).parentName(updateStudentRecordsDetail.getParentName())
                .parentRelation(updateStudentRecordsDetail.getParentRelation())
                .mobileNumber(updateStudentRecordsDetail.getMobileNumber())
                .residenceNumber(updateStudentRecordsDetail.getResidenceNumber())
                .address(updateStudentRecordsDetail.getAddress()).build();
    }

    @Override
    public String deleteBulkStudentRecordsDetail(Integer bulkStuId) {
        BulkStudentRecordsDetail existBulkStudentRecordsDetail = bulkStudentRecordsDetailRepository.findById(bulkStuId)
                .orElseThrow(() -> new RuntimeException("Not Found!!"));
            bulkStudentRecordsDetailRepository.deleteById(existBulkStudentRecordsDetail.getBulkStuId());
            return "Record Delete Successfully!!!";
    }

    @Override
    public BulkStudentRecordsDetailDto getBulkStudentRecordsDetailByStuRegNumber(String stuRegNumber) {
        BulkStudentRecordsDetail bulkStudentRecordsDetail = bulkStudentRecordsDetailRepository
                .findBulkStudentRecordsDetailBySchoolRegNumber(stuRegNumber);
        return BulkStudentRecordsDetailDto.builder()
                .firstName(bulkStudentRecordsDetail.getFirstName()).lastName(bulkStudentRecordsDetail.getLastName())
                .fullName(bulkStudentRecordsDetail.getFullName()).schoolRegNumber(bulkStudentRecordsDetail.getSchoolRegNumber())
                .className(bulkStudentRecordsDetail.getClassName()).medium(bulkStudentRecordsDetail.getMedium())
                .religion(bulkStudentRecordsDetail.getReligion()).parentName(bulkStudentRecordsDetail.getParentName())
                .parentRelation(bulkStudentRecordsDetail.getParentRelation())
                .mobileNumber(bulkStudentRecordsDetail.getMobileNumber())
                .residenceNumber(bulkStudentRecordsDetail.getResidenceNumber())
                .address(bulkStudentRecordsDetail.getAddress()).build();
    }

    @Override
    public List<BulkStudentRecordsDetailDto> getAllBulkStudentRecordDetails() {
        return bulkStudentRecordsDetailRepository.findAllBulkStudentRecordsDetails();
    }

    private List<BulkStudentRecordsDetailDto> formatToDto(List<BulkStudentRecordsDetail> recordsDetails){
        List<BulkStudentRecordsDetailDto> newRecords = new ArrayList<>();
        for (BulkStudentRecordsDetail recordsDetail : recordsDetails) {
            BulkStudentRecordsDetailDto bulkStudentRecordsDetailDto = new BulkStudentRecordsDetailDto();
            BeanUtils.copyProperties(recordsDetail,bulkStudentRecordsDetailDto);
            newRecords.add(bulkStudentRecordsDetailDto);
        }
        return newRecords;
    }
}
