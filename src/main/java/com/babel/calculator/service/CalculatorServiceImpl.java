package com.babel.calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.babel.calculator.operation.Operation;

@Service
public class CalculatorServiceImpl implements CalculatorService {



	@Override
	public Double calculate(BigDecimal firstElement, BigDecimal secondElement, String operation) {
		Double result = null;
		
		if (operation.compareToIgnoreCase(Operation.ADD.name()) == 0)
			result = firstElement.add(secondElement).doubleValue();

		if (operation.compareToIgnoreCase(Operation.SUBSTRAC.name()) == 0)
			result = firstElement.subtract(secondElement).doubleValue();

		if (operation.compareToIgnoreCase(Operation.MULTIPLY.name()) == 0)
			result = firstElement.multiply(secondElement).doubleValue();

		if (operation.compareToIgnoreCase(Operation.DIVIDE.name()) == 0)
			result = firstElement.divide(secondElement, 4, RoundingMode.HALF_UP)
					.doubleValue();

		return result;
	}

}
