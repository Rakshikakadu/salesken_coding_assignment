package com.salesken.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.entity.StudentDetails;
import com.salesken.entity.StudentMarksSemesterWise;
import com.salesken.exceptions.StudentDetailsException;
import com.salesken.exceptions.StudentMarksSemesterWiseException;
import com.salesken.repository.StudentDetailsRepo;
import com.salesken.repository.StudentMarksSemesterWiseRepo;

@Service
public class StudentInterfaceImpl implements StudentInterface{
	
	@Autowired
	private StudentDetailsRepo studentdetailsRepo;
	
	
	
	@Override
	public StudentDetails addStudents(StudentDetails studentDetails){
		
		
		return studentdetailsRepo.save(studentDetails);
	}

	@Override
	public List<StudentDetails> getAllStudents() throws StudentDetailsException {
		
		List<StudentDetails> students = studentdetailsRepo.findAll();
		
		if(students.isEmpty()) {
			throw new StudentDetailsException("No student found");
		}
		
		return students;
	}

	@Override
	public int averageMarks() {
		
		List<Integer>totalMarks= new ArrayList();
		List<StudentDetails> students = studentdetailsRepo.findAll();
		
		for(StudentDetails student : students) {
			int sum = 0;
			sum += student.getEnglish() + student.getMaths() + student.getScience();
			
			totalMarks.add(sum);
		}
		
		int averageMarks =0;
		int totalSum=0;
		for(Integer total : totalMarks) {
			totalSum += total;
		}
		
		averageMarks = totalSum/totalMarks.size();
		
		return averageMarks;
	}

	@Override
	public List<StudentDetails> topTwoStudents() {
		
		return null;
	}


}
