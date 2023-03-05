package com.salesken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.entity.StudentDetails;
import com.salesken.entity.StudentMarksSemesterWise;
import com.salesken.exceptions.StudentDetailsException;
import com.salesken.services.StudentInterfaceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentInterfaceImpl studentService;
	
	@PostMapping("/register")
	public ResponseEntity<StudentDetails> addStudentHandler(@RequestBody StudentDetails sdetails){
		
		return new ResponseEntity<StudentDetails>(studentService.addStudents(sdetails),HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDetails>> getStudentHandler() throws StudentDetailsException{
		
		return new ResponseEntity<List<StudentDetails>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@PostMapping("/addMarks/{id}")
	public ResponseEntity<StudentDetails> addMarksOfStudentHandler(@PathVariable Integer id, @RequestBody StudentMarksSemesterWise smsw){
		
		return new ResponseEntity<StudentDetails>(studentService.addMarksOfStudent(id, smsw),HttpStatus.OK);
	}
	
	@GetMapping("/averageMarks")
	public ResponseEntity<Integer> getaverageMarksHandler(@RequestParam String subject) throws StudentDetailsException{
		
		return new ResponseEntity<Integer>(studentService.averageStudentMarksInSubject(subject),HttpStatus.OK);
	}
	
	@GetMapping("/percentage")
	public ResponseEntity<Double> getPercentageOfAverageMarksHandler() throws StudentDetailsException{
		
		return new ResponseEntity<Double>(studentService.averagePercentageOfWholeClass(),HttpStatus.OK);
	}
	
	@GetMapping("/toppers")
	public ResponseEntity<List<StudentDetails>> getTopTwoStudntsHandler() throws StudentDetailsException{
		
		return new ResponseEntity<List<StudentDetails>>(studentService.topTwoStudents(),HttpStatus.OK);
	}
	
	
	
//	@GetMapping("/averageMarks")
//	public ResponseEntity<Integer> getStudentAveraheMarksHandler() {
//		
//		return new ResponseEntity<Integer>(studentService.averageMarks(),HttpStatus.OK);
//	}
	
}
