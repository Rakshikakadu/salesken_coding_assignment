package com.salesken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesken.entity.StudentDetails;

@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentDetails, Integer>{

}
