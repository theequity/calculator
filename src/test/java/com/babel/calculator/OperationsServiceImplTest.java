package com.babel.calculator;

import com.babel.calculator.service.CalculatorService;
import com.babel.calculator.service.CalculatorServiceImpl;


import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class OperationsServiceImplTest {

    private static CalculatorService calculatorService;

    @BeforeAll
    public static void serviceImpl() {
    	calculatorService = new CalculatorServiceImpl();
    }

  
    @Test
    public void serviceAddTest() {
        Assertions.assertEquals(calculatorService.calculate(BigDecimal.valueOf(5), BigDecimal.valueOf(5), "add"), 10);
    }

 
    @Test
    public void serviceSubTest() {
        Assertions.assertEquals(calculatorService.calculate(BigDecimal.valueOf(5), BigDecimal.valueOf(5), "sub"), 0);
    }
}
