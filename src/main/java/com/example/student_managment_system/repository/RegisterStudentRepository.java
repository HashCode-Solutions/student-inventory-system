package com.example.student_managment_system.repository;

import com.example.student_managment_system.entity.RegisterStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterStudentRepository extends JpaRepository<RegisterStudent, Integer> {
}
