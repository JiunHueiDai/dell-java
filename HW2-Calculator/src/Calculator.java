import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean continueCal = true;
		Scanner reader = new Scanner(System.in);
		
		while(continueCal)
		{
			System.out.println("Please enter the first value:");
			double value1 = Double.parseDouble(reader.nextLine()); 
			System.out.println("Please enter the second value:");
			double value2 = Double.parseDouble(reader.nextLine()); 
			System.out.println("");
			calculateResults(value1, value2);
			
			System.out.println("Do you want to calculate other values (y or n)?");
			String temp = reader.nextLine(); 
			continueCal = temp.toUpperCase().equals("Y") ? true : false;
			System.out.println("");
		}
		
		reader.close();
	}
	
	private static void calculateResults(double value1, double value2) {
		double result = 0;
		String template = "%s %s %s = %s";

		result = add(value1, value2);
		System.out.println(String.format(template, value1, "+", value2, result));

		result = minus(value1, value2);
		System.out.println(String.format(template, value1, "-", value2, result));

		result = multiply(value1, value2);
		System.out.println(String.format(template, value1, "*", value2, result));

		result = divide(value1, value2);
		System.out.println(String.format(template, value1, "/", value2, result));
	}
	
	private static double add(double value1, double value2) {
		return value1 + value2;
	}

	private static double minus(double value1, double value2) {
		return value1 - value2;
	}
	
	private static double multiply(double value1, double value2) {
		return value1 * value2;
	}
	
	private static double divide(double value1, double value2) {
		return value1 / value2;
	}
	
}
