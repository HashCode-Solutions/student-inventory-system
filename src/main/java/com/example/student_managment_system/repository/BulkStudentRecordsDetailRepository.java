package com.example.student_managment_system.repository;

import com.example.student_managment_system.dto.BulkStudentRecordsDetailDto;
import com.example.student_managment_system.entity.BulkStudentRecordsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulkStudentRecordsDetailRepository extends JpaRepository<BulkStudentRecordsDetail, Integer> {

    BulkStudentRecordsDetail findBulkStudentRecordsDetailBySchoolRegNumber(String stuRegNumber);

    @Query("SELECT new com.example.student_managment_system.dto.BulkStudentRecordsDetailDto(" +
            "BSRD.bulkStuId," +
            "BSRD.firstName," +
            "BSRD.lastName," +
            "BSRD.fullName," +
            "BSRD.schoolRegNumber," +
            "BSRD.className," +
            "BSRD.medium," +
            "BSRD.religion," +
            "BSRD.parentName," +
            "BSRD.parentRelation," +
            "BSRD.mobileNumber," +
            "BSRD.residenceNumber," +
            "BSRD.address)" +
            "FROM BulkStudentRecordsDetail BSRD")
    List<BulkStudentRecordsDetailDto> findAllBulkStudentRecordsDetails();
}
