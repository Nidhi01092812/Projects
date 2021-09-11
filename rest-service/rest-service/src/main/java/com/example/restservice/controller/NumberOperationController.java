package com.example.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.NumberOperationRequestModel;
import com.example.restservice.model.NumberOperationResponseModel;
import com.example.restservice.service.NumberOperationService;



@RestController
@RequestMapping(path = "web")
  public class NumberOperationController {
	@Autowired
	NumberOperationService numberOperationService;
	
	
	
    @PostMapping(path = "/api/numberoperations", consumes = "application/json", produces = "application/json")
	public ResponseEntity<NumberOperationResponseModel> calculate(@RequestBody NumberOperationRequestModel numberOperationtModel) {
		 
		NumberOperationResponseModel numberOperationResponseModel =numberOperationService.operateOnNumbers(numberOperationtModel.getInput());
		
		return ResponseEntity.ok().body(numberOperationResponseModel);
		
		
	}

}
