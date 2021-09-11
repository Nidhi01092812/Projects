package com.example.restservice.service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.restservice.model.NumberOperationResponseModel;
import com.example.restservice.model.Result;
import com.example.restservice.model.Status;

@Service
public class NumberOperationService {

	public NumberOperationResponseModel operateOnNumbers(int numbers[]) {

		int sum = createSumofNumbers(numbers);
		double avg = createAvgofNumbers(numbers);
		int[] list = createNumberGreaterThanAvg(numbers);

		Result result = new Result(sum, avg, list);

		NumberOperationResponseModel numberOperationResponseModel = new NumberOperationResponseModel(Status.SUCCESS, result);
		return numberOperationResponseModel;

	}

	private int createSumofNumbers(int numbers[]) {

		return Arrays.stream(numbers).sum();

	}

	private double createAvgofNumbers(int numbers[]) {

		return Arrays.stream(numbers).average().getAsDouble();

	}

	private int[] createNumberGreaterThanAvg(int numbers[]) {

		List<Integer> list = Arrays.stream(numbers).filter(i -> i > createAvgofNumbers(numbers)).boxed()
				.collect(Collectors.toList());
		return list.stream().mapToInt(i -> i).toArray();

	}

}
