package com.babel.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babel.calculator.service.CalculatorService;

import io.corp.calculator.TracerImpl;

@RestController
@RequestMapping("/api")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;
	private TracerImpl tracer = new TracerImpl();

	@GetMapping(value = "/calculate")
	public ResponseEntity<String> calculate(@RequestParam(name = "firstElement") BigDecimal firstElement,
			@RequestParam(name = "secondElement") BigDecimal secondElement,
			@RequestParam(name = "operation") String operation) {

		Double result = null;
		ResponseEntity<String> response ;
		try {
			result = this.calculatorService.calculate(firstElement, secondElement, operation);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			tracer.trace(response);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		tracer.trace(result);
		return ResponseEntity.ok(result.toString());
	}

}
