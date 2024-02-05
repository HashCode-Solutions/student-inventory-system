package com.example.student_managment_system.repository;

import com.example.student_managment_system.dto.KycStudentRecordsDto;
import com.example.student_managment_system.entity.KycStudentRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KycStudentRecordsRepository extends JpaRepository<KycStudentRecords, Integer> {

    @Query("SELECT new com.example.student_managment_system.dto.KycStudentRecordsDto(" +
            "KSR.kycStuId," +
            "KSR.firstName," +
            "KSR.lastName," +
            "KSR.fullName," +
            "KSR.schoolRegNumber," +
            "KSR.classNumber," +
            "KSR.medium," +
            "KSR.religion," +
            "KSR.parentName," +
            "KSR.parentRelation," +
            "KSR.mobileNumber," +
            "KSR.residenceNumber," +
            "KSR.address)" +
            "FROM KycStudentRecords KSR")
    List<KycStudentRecordsDto> findAllKycStudentRecordsDetails();

}
