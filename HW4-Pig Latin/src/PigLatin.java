import java.util.Arrays;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter your word:");
		Scanner reader = new Scanner(System.in);
		String word = reader.nextLine();

		String pigLatin = "";
		
		if (ifWordStartWithVowel(word)) {
			pigLatin = word + "yay";
		}
		
		System.out.println("pig latin: " + pigLatin);
		reader.close();
	}
	
	private static boolean ifWordStartWithVowel(String word) {
		char firstChar = word.trim().charAt(0);
		System.out.println("a:" + firstChar);
		char[] vowels = {'a','e','i','o','u'};
		boolean test = Arrays.asList(vowels).indexOf(firstChar) > -1;
		System.out.println("a:" + Arrays.asList(vowels).indexOf('a'));
		
		return Arrays.asList(vowels).indexOf(firstChar) > -1 ? true : false;
	}

}
