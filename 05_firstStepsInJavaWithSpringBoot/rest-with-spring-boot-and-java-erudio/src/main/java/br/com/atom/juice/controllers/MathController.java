package br.com.atom.juice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.atom.juice.convertes.NumberConverter;
import br.com.atom.juice.exceptions.UnsupportedMathOperationException;
import br.com.atom.juice.math.SimpleMath;

@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();

	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/pow/{numberOne}/{numberTwo}")
	public Double pow(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.pow(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}

	@GetMapping(value = "/div/{dividend}/{divisor}")
	public Double div(@PathVariable(value = "dividend") String dividend,
			@PathVariable(value = "divisor") String divisor) {

		if (!NumberConverter.isNumeric(dividend) || !NumberConverter.isNumeric(divisor)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		if (NumberConverter.convertToDouble(divisor).equals(0D)) {
			throw new UnsupportedMathOperationException("Divisor cannot be zero");
		}

		return math.div(NumberConverter.convertToDouble(dividend), NumberConverter.convertToDouble(divisor));
	}

	@GetMapping(value = "/sqrt/{numberOne}")
	public Double sqrt(@PathVariable(value = "numberOne") String numberOne) {

		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.sqrt(NumberConverter.convertToDouble(numberOne));
	}

	@GetMapping(value = "/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}

}
