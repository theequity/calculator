package com.babel.calculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.babel.calculator.operation.Operation;


@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public Double calculate(BigDecimal firstElement, BigDecimal secondElement, String value) {
		Double result = null;
		Operation operation = Operation.validateOperation(value);

		if (operation.equals(Operation.ADD))
			result = firstElement.add(secondElement).doubleValue();

		if (operation.equals(Operation.SUB))
			result = firstElement.subtract(secondElement).doubleValue();

		return result;
	}

}
