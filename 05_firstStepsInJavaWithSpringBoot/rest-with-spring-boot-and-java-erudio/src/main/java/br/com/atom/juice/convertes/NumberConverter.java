package br.com.atom.juice.convertes;

public class NumberConverter {
	public static Double convertToDouble(String str) {
		if (str == null)
			return 0D;
		String number = str.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String str) {
		if (str == null)
			return false;
		String number = str.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
