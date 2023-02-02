package com.babel.calculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

	Double calculate(BigDecimal firstElement, BigDecimal secopndElement, String operation);

}
