import java.util.Arrays;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		String pigLatinSartWithVowel= "";
		String pigLatinStartWithCon = "";
		String pigLatinWithVowel = "";
		System.out.println("Please enter your word:");
		Scanner reader = new Scanner(System.in);
		String word = reader.nextLine();

		pigLatinSartWithVowel = getPigLatinStartWithVowel(word);
		System.out.println("pig latin start with vowel: " + pigLatinSartWithVowel);
		pigLatinStartWithCon = getPigLatinStartWithCon(word);	
		System.out.println("pig latin start with con: " + pigLatinStartWithCon);
		pigLatinWithVowel = checkIfAnyVowel(word);	
		System.out.println("pig latin start with con: " + pigLatinWithVowel);
		
		reader.close();
	}

	private static String getPigLatinStartWithVowel(String word) {
		char firstChar = word.trim().charAt(0);
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		for (char vowel : vowels) {
			if (vowel == firstChar) {
				return word + "yay";
			}
		}
		return word;
	}

	private static String getPigLatinStartWithCon(String word) {
		char[] chars = word.toCharArray();
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		String frontWord = "";
		
		while(chars.length > 0) {
			boolean foundVowel = false;
			for (char vowel : vowels) {
				if(chars[0] == vowel) {
					foundVowel = true;
				}
			}

			if(foundVowel) {
				return new String(chars) + frontWord + "ay";
			}
			else {
				frontWord += chars[0];
				chars = Arrays.copyOfRange(chars, 1, chars.length);
			}
		}
		return word;
	}
	
	private static String checkIfAnyVowel(String word) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		char[] wordChars = word.toCharArray();
		boolean foundVowel = false;
		
		for(char wordChar : wordChars) {
			for( char vowel :  vowels) {
				if(wordChar == vowel) {
					foundVowel = true;
				}
			}
		}
		
		if (!foundVowel) {
			return word + "ay";
		}
		return word;
	}
}
