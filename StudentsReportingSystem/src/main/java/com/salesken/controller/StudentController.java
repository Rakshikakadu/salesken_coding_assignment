package com.salesken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.entity.StudentDetails;
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
	
	@GetMapping("/averageMarks")
	public ResponseEntity<Integer> getStudentAveraheMarksHandler() {
		
		return new ResponseEntity<Integer>(studentService.averageMarks(),HttpStatus.OK);
	}
	
}
