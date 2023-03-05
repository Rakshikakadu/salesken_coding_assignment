package com.salesken.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class StudentMarksSemesterWise {

	private Integer semester1English;
	private Integer semester1Maths;
	private Integer semester1Science;

	private Integer semester2English;
	private Integer semester2Maths;
	private Integer semester2Science;

}
