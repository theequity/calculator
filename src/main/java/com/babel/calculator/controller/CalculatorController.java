package com.babel.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babel.calculator.service.CalculatorService;



@RestController
@RequestMapping("/api")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	
	@GetMapping(value = "/calculate")
	public ResponseEntity<Double> calculate(
			@RequestParam(name = "firstElement") BigDecimal firstElement,
            @RequestParam(name = "secondElement") BigDecimal secondElement,
            @RequestParam(name = "operation") String operation) {
		
		Double result = null;
		try {
			result = this.calculatorService.calculate(firstElement, secondElement, operation);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(result);
	}

}
