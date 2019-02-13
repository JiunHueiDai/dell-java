import java.util.Collections;
import java.util.Scanner;

public class Game {
	private String _word;
	private char[] _mockWordChar = null;
	private int numberOfLeftLetters = 0;

	public Game(String word) {
		_word = word;
		mockQuestion();
		numberOfLeftLetters = _word.length();
	}

	public void PlayGame() {
		boolean continueGuess = true;
		Scanner reader = new Scanner(System.in);
		int matchingPos = -1;
		while (continueGuess == true) {
			System.out.println("Please enter a letter.");
			String guess = reader.nextLine().toUpperCase();
			if (checkIfGuessValid(guess)) {
				matchingPos = _word.indexOf(guess);
				if (matchingPos > -1 && matchingPos < _word.length()) {
					_mockWordChar[matchingPos] = guess.charAt(0);
					displayResult();
					numberOfLeftLetters--;
					if (numberOfLeftLetters == 0) {
						continueGuess =false;
						System.out.println("Congrats!! You won the game. The word is \"" + _word + "\".");
					}
				}else
				{
					System.out.println("Sorry, no matched.");
				}
			} else {
				System.out.println("Please enter one single letter.");
			}
		}

	}

	private void mockQuestion() {
		_mockWordChar = String.join("", Collections.nCopies(_word.length(), "_")).toCharArray();
	}

	private boolean checkIfGuessValid(String word) {
		char[] wordChar = word.toCharArray();

		if (wordChar.length > 1) {
			return false;
		}
		return true;
	}

	private void displayResult() {
		String temp = "";
		for (int i = 0; i < _mockWordChar.length; i++) {
			temp = temp + _mockWordChar[i] + " ";
		}
		System.out.println(temp);
	}
}
