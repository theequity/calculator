package com.babel.calculator.vo;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class CalculatorVO {
	
	private BigDecimal firstElement;
	private BigDecimal secondElement;
	private String operation;

}
