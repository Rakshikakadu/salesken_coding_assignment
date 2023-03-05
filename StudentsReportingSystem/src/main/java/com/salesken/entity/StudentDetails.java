package com.salesken.entity;



import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollno;
	private String studentName;
	private String courseName;
	
	
	@Embedded
	private StudentMarksSemesterWise studentMarks ;
	
}
