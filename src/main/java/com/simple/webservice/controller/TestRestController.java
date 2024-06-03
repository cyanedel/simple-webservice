package com.simple.webservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.webservice.service.calculator.CalculatorService;
import com.simple.webservice.service.hello.HelloService;

@RestController
@RequestMapping("/api")
public class TestRestController {
	private final CalculatorService calculatorService;
	public TestRestController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/getLocalTime")
	public String getLocalTime() {
		return HelloService.getLocalTime();
	}

	@GetMapping("/greet/{username}")
	public String greet(@PathVariable String username) {
		return "Hello there "+ username + "!";
	}

	@GetMapping("/add/{num1}/{num2}")
	public String addNumber(@PathVariable int num1, @PathVariable int num2) {
		int result = calculatorService.add(num1, num2);
		return "Calculation result:" + result;
	}

	@GetMapping("/subtract/{num1}/{num2}")
	public String subtractNumber(@PathVariable int num1, @PathVariable int num2) {
		int result = calculatorService.subtract(num1, num2);
		return "Calculation result:" + result;
	}

	@GetMapping("/multiply/{num1}/{num2}")
	public String multiplyNumber(@PathVariable int num1, @PathVariable int num2) {
		int result = calculatorService.multiply(num1, num2);
		return "Calculation result:" + result;
	}

	@GetMapping("/divide/{num1}/{num2}")
	public String divideNumber(@PathVariable int num1, @PathVariable int num2) {
		int result = calculatorService.divide(num1, num2);
		return "Calculation result:" + result;
	}
}