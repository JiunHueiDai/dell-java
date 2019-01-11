import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		boolean continueGame = true;
		Scanner reader = new Scanner(System.in);
		
		while (continueGame) {
			System.out.println("Please enter your word:");
			String word = reader.nextLine().trim();
			String pigLatinWord = playGame(word);

			System.out.println(pigLatinWord);
			System.out.println("");
			System.out.println("Translate another word?");

			if(reader.nextLine().trim().toUpperCase().equals("N")) {
				continueGame = false;
			}
		}
		
		reader.close();
	}

	private static String playGame(String word) {
		if (hasFirstVowelLetter(word)) {
			return word + "yay";
		} else {
			if (!hasAnyVowelAfterFirstLetter(word)) {
				return word + "ay";
			} else {
				return getMiddleVowelPigLatinWord(word, getVowelPos(word));
			}
		}
	}
	
	private static boolean hasFirstVowelLetter(String word) {
		String firstChar = Character.toString(word.charAt(0));

		if (hasVowel(firstChar)) {
			return true;
		}

		return false;
	}

	private static boolean hasAnyVowelAfterFirstLetter(String word) {
		return hasVowel(word);
	}

	private static int getVowelPos(String word) {
		char[] wordCharArray = word.toCharArray();

		for (int i = 0; i < wordCharArray.length; i++) {
			if (hasVowel(Character.toString(wordCharArray[i]))) {
				return i;
			}
		}

		return -1;
	}

	private static String getMiddleVowelPigLatinWord(String word, int pos) {
		return word.substring(pos, word.length()) + word.substring(0, pos) + "ay";
	}

	private static boolean hasVowel(String word) {
		String[] vowels = { "a", "e", "i", "o", "u" };
		for (String vowel : vowels) {
			if (word.contains(vowel))
				return true;
		}
		return false;
	}
}
