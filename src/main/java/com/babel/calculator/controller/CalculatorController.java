package com.babel.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babel.calculator.service.CalculatorService;
import com.babel.calculator.vo.CalculatorVO;



@RestController
@RequestMapping("/api")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	
	@GetMapping(value = "/calculate")
	public ResponseEntity<Double> calculate(@RequestBody CalculatorVO calculatorVO) {
		
		Double result = null;
		try {
			result = this.calculatorService.calculate(calculatorVO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(result);
	}

}
