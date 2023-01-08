package br.com.atom.juice.math;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {

		return numberOne + numberTwo;
	}

	public Double sub(Double numberOne, Double numberTwo) {

		return numberOne - numberTwo;
	}

	public Double mult(Double numberOne, Double numberTwo) {

		return numberOne * numberTwo;
	}

	public Double pow(Double numberOne, Double numberTwo) {

		return Math.pow(numberOne, numberTwo);
	}

	public Double div(Double dividend, Double divisor) {

		return dividend / divisor;
	}

	public Double sqrt(Double numberOne) {

		return Math.sqrt(numberOne);
	}

	public Double mean(Double numberOne, Double numberTwo) {

		return (numberOne + numberTwo) / 2;
	}

}
