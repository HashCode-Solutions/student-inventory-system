package com.example.student_managment_system.repository;

import com.example.student_managment_system.dto.registerStudent.RegisterStudentTableDto;
import com.example.student_managment_system.entity.RegisterStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterStudentRepository extends JpaRepository<RegisterStudent, Integer> {

    @Query("SELECT new com.example.student_managment_system.dto.registerStudent.RegisterStudentTableDto(" +
            "RS.registerStuId," +
            "KSR.classNumber," +
            "RS.status," +
            "KSR.fullName)" +
            "FROM RegisterStudent RS INNER JOIN BulkStudentRecordsDetail BSRD ON RS.bulkStudentRecords.bulkStuId = BSRD.bulkStuId " +
            "INNER JOIN KycStudentRecords KSR ON RS.kycStudentRecords.kycStuId = KSR.kycStuId")
    List<RegisterStudentTableDto> findAllRegisterStudentsDetails();

}
