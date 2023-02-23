package com.salesken.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	private int english;
	private int maths;
	private int science;
	
//	@OneToMany
//	List<StudentMarksSemesterWise> marks = new ArrayList<>();
	
	
}
