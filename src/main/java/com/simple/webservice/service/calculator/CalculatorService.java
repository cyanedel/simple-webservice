package com.simple.webservice.service.calculator;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
  int add(int num1, int num2);
  int subtract(int num1, int num2);
  int multiply(int num1, int num2);
  int divide(int num1, int num2);
}