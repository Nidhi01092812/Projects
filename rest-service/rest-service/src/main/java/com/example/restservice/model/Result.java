package com.example.restservice.model;

import com.sun.tools.javac.code.Attribute.Array;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Result {
	

	int sum;
	double avg;
	int greaterThanAverage[];

	
}
