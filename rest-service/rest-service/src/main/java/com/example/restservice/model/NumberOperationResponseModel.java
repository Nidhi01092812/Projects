package com.example.restservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberOperationResponseModel {
	
	private Status status;

	private Result results;
	
		
}
