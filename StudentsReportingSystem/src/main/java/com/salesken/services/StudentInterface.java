package com.salesken.services;

import java.util.List;

import com.salesken.entity.StudentDetails;
import com.salesken.entity.StudentMarksSemesterWise;
import com.salesken.exceptions.StudentDetailsException;
import com.salesken.exceptions.StudentMarksSemesterWiseException;

public interface StudentInterface {
	
	public StudentDetails addStudents(StudentDetails studentDetails);
	
	public List<StudentDetails> getAllStudents() throws StudentDetailsException;
	
	public int averageMarks();
	
	public List<StudentDetails> topTwoStudents();
	
}
