import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CollectStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Plesae enter collections of numbers:");
		Scanner reader = new Scanner(System.in);
		String words = reader.nextLine().trim();
		String[] wordArray= words.split(",");
		double[] doubleValues = Arrays.stream(wordArray)
                .mapToDouble(Double::parseDouble)
                .toArray();
		
		Arrays.sort(doubleValues);
	
		double minValue = getMin(doubleValues);
		double maxValue = getMax(doubleValues);
		int numberOfElements = getNumberOfElements(doubleValues);
		double averageOfArray = getAverage(doubleValues);
		double sumOfArray = getSum(doubleValues);
		
		System.out.println("Min value of the array:" + minValue);
		System.out.println("Max value of the array:" + maxValue);
		System.out.println("Number of Elements in the array:" + numberOfElements);
		System.out.println("Average value of the array:" + averageOfArray);
		System.out.println("Sum of the array:" + sumOfArray);
	}
	
	private static double getMin(double[] doubleValues) {	
		return doubleValues[0];
	}

	private static double getMax(double[] doubleValues) {
		return doubleValues[doubleValues.length -1];
	}
	
	private static int getNumberOfElements(double[] doubleValues) {
		return doubleValues.length;
	}
	
	private static double getSum(double[] doubleValues) {
		return Arrays.stream(doubleValues).sum();
	}
	
	private static double getAverage(double[] doubleValues) {
		return (double)getSum(doubleValues)/getNumberOfElements(doubleValues);
	}
}
