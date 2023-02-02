package com.babel.calculator.service;

import java.math.RoundingMode;


import org.springframework.stereotype.Service;

import com.babel.calculator.vo.CalculatorVO;
import com.babel.calculator.vo.Operation;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public Double calculate(CalculatorVO calculatorVO) {

		Double result = null;
	
	
		if (calculatorVO.getOperation() == null) 
			throw new RuntimeException("Impossible to process: " + calculatorVO.getOperation());
		
		if (calculatorVO.getOperation().compareToIgnoreCase(Operation.ADD.name()) == 0)
			result = calculatorVO.getFirstElement().add(calculatorVO.getSecondElement()).doubleValue();

		if (calculatorVO.getOperation().compareToIgnoreCase(Operation.SUBSTRAC.name()) == 0)
			result = calculatorVO.getFirstElement().subtract(calculatorVO.getSecondElement()).doubleValue();

		if (calculatorVO.getOperation().compareToIgnoreCase(Operation.MULTIPLY.name()) == 0)
			result = calculatorVO.getFirstElement().multiply(calculatorVO.getSecondElement()).doubleValue();

		if (calculatorVO.getOperation().compareToIgnoreCase(Operation.DIVIDE.name()) == 0)
			result = calculatorVO.getFirstElement().divide(calculatorVO.getSecondElement(), 4, RoundingMode.HALF_UP)
					.doubleValue();

		return result;

	}

}
