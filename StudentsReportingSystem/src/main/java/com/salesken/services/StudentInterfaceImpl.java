package com.salesken.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.entity.StudentDetails;
import com.salesken.entity.StudentMarksSemesterWise;
import com.salesken.exceptions.StudentDetailsException;

import com.salesken.repository.StudentDetailsRepo;

@Service
public class StudentInterfaceImpl implements StudentInterface {

	@Autowired
	private StudentDetailsRepo studentdetailsRepo;

	@Override
	public StudentDetails addStudents(StudentDetails studentDetails) {

		return studentdetailsRepo.save(studentDetails);
	}

	@Override
	public List<StudentDetails> getAllStudents() throws StudentDetailsException {

		List<StudentDetails> students = studentdetailsRepo.findAll();

		if (students.isEmpty()) {
			throw new StudentDetailsException("No student found");
		}

		return students;
	}

	@Override
	public StudentDetails addMarksOfStudent(Integer id, StudentMarksSemesterWise sms) {
		// TODO Auto-generated method stub

		StudentDetails student = studentdetailsRepo.findById(id).orElseThrow(() -> new IllegalArgumentException());

		StudentMarksSemesterWise marks = student.getStudentMarks();

		if (marks != null) {
			if (marks.getSemester1English() == null && sms.getSemester1English() != null) {
				marks.setSemester1English(sms.getSemester1English());
			}

			if (marks.getSemester1Maths() == null && sms.getSemester1Maths() != null) {
				marks.setSemester1Maths(sms.getSemester1Maths());
			}

			if (marks.getSemester1Science() == null && sms.getSemester1Science() != null) {
				marks.setSemester1Science(sms.getSemester1Science());
			}

			if (marks.getSemester2English() == null && sms.getSemester2English() != null) {
				marks.setSemester2English(sms.getSemester2English());
			}

			if (marks.getSemester2Maths() == null && sms.getSemester2Maths() != null) {
				marks.setSemester2Maths(sms.getSemester2Maths());
			}

			if (marks.getSemester2Science() == null && sms.getSemester2Science() != null) {
				marks.setSemester2Science(sms.getSemester2Science());
			}

			student.setStudentMarks(marks);
		} else {
			student.setStudentMarks(sms);
		}

		return studentdetailsRepo.save(student);
	}

	@Override
	public Integer averageStudentMarksInSubject(String subject) {

		List<StudentDetails> students = studentdetailsRepo.findAll();
		Integer sum = 0;
		Integer count =0;
		for (StudentDetails student : students) {
			StudentMarksSemesterWise marks = student.getStudentMarks();
			
			if(marks!=null) {
				
				if( (subject.equals("English") || subject.equals("ENGLISH") || subject.equals("english"))) {
					if(marks.getSemester1English() != null) {
						sum+=marks.getSemester1English();
					}else if(marks.getSemester2English() != null) {
						sum+=marks.getSemester2English();
					}else {
						sum+=marks.getSemester1English() + marks.getSemester2English();
					}
					
					
				}else if(subject.equals("Maths") || subject.equals("MATHS") || subject.equals("maths")) {
					
					if(marks.getSemester1Maths() != null) {
						sum+=marks.getSemester1Maths();
					}else if(marks.getSemester2Maths() != null) {
						sum+=marks.getSemester2Maths();
					}else {
						sum+=marks.getSemester1Maths() + marks.getSemester2Maths();
					}
					
					
				}else if(subject.equals("Science") || subject.equals("SCIENCE") || subject.equals("science")) {
					
					if(marks.getSemester1Science() != null) {
						sum+=marks.getSemester1Science();
					}else if(marks.getSemester2Science() != null) {
						sum+=marks.getSemester2Science();
					}else {
						sum+=marks.getSemester1Science() + marks.getSemester2Science();
					}
					
				}
				count++;
			}
			
			
		}
		
		Integer Average =0;
		Average = (sum)/count;
		return  Average;
	}

	@Override
	public Double averagePercentageOfWholeClass() {
		
		List<StudentDetails> students = studentdetailsRepo.findAll();
		
		Double sum = 0.0;
		Double totalsum=0.0;
		
		for(StudentDetails student : students) {
			
			StudentMarksSemesterWise marks = student.getStudentMarks();
			
			if(marks != null) {
				if(marks.getSemester2English() == null && marks.getSemester2Maths() == null && marks.getSemester2Science()==null) {
					
					sum += marks.getSemester1English() + marks.getSemester1Maths() + marks.getSemester1Science();
					totalsum += 300;
				
				}else {
					
					sum += marks.getSemester2English() + marks.getSemester2Maths() + marks.getSemester2Science();
					totalsum+=300;
				
				}
			}
			
			
			
		}
		
		Double percentage = (sum / totalsum)*100;
		
		return percentage;
	}

	
}
