package com.salesken.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesken.entity.StudentDetails;

@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentDetails, Integer>{
	
	@Query(value = "select * from student_details ORDER BY (semester1English+semester1Maths+semester1Science+semester2English+semester2Maths+semester2Science) DESC LIMIT 2",nativeQuery = true)
	public List<StudentDetails> topTwo();
	
}
