import java.util.Collections;
import java.util.Scanner;

public class Player {
	private String _word;
	private char[] _mockWordChar = null;
	private int numberOfLeftLetters = 0;

	/*
	 * class construction to pass in word, calculate the number of letters, and also
	 * create a mock up word with the same length in underline express at each char
	 */
	public Player(String word) {
		_word = word;
		mockQuestion();
		numberOfLeftLetters = _word.length();
	}

	/* play the game with user */
	public void PlayGame() {
		boolean continueGuess = true;
		Scanner reader = new Scanner(System.in);
		String guess = "";

		while (continueGuess == true) {
			guess = getUserInput(reader);

			if (isValidAndMatch(guess) == true)
			{
				replaceCharInMockWord(guess);
				displayWord();
				checkGameResult();
				continueGuess = continuePlaying();
			}
		}
		reader.close();
	}

	/*
	 * check the user's guess if valid and also if match any character with the
	 * question word
	 */
	private boolean isValidAndMatch(String guess) {
		if (!checkIfUserInputIsValid(guess)) {
			System.out.println("Please enter one single letter.");
			return false;
		}

		if (!hasMatchingChar(guess)) {
			System.out.println("Sorry, no matched.");
			return false;
		}

		return true;
	}

	/* check if it has matching character with the question word */
	private boolean hasMatchingChar(String guess) {

		int matchingPos = _word.indexOf(guess);

		if (matchingPos > -1 && matchingPos < _word.length()) {
			return true;
		}

		return false;
	}

	/*
	 * if the number of left letters that haven't been matched is bigger than 0,
	 * continue playing the game
	 */
	private boolean continuePlaying() {
		return numberOfLeftLetters == 0 ? false : true;
	}

	/*
	 * if continue playing the game is true, it means the user hasn't win the game
	 * so winning message doesn't need to be displayed
	 */
	private void checkGameResult() {
		if (!continuePlaying()) {
			System.out.println("");
			System.out.println("Congrats!! You won the game. The word is \"" + _word + "\".");
		}
	}

	/* get user input as the guessing character that user provide */
	private String getUserInput(Scanner reader) {
		System.out.println("Please enter a letter.");
		return reader.nextLine().toUpperCase();
	}

	/* replace all the matching characters in the mock up word array */
	private void replaceCharInMockWord(String guess) {
		char[] wordCharArray = _word.toCharArray();
		for (int i = 0; i < wordCharArray.length; i++) {
			if (wordCharArray[i] == guess.charAt(0)) {
				_mockWordChar[i] = guess.charAt(0);
				numberOfLeftLetters--;
			}
		}
	}

	/*
	 * create a mock up char array to have the same length of question word and each
	 * spot in the array has underline ("_")character
	 */
	private void mockQuestion() {
		_mockWordChar = String.join("", Collections.nCopies(_word.length(), "_")).toCharArray();
	}

	/* user can only enter one character each time */
	private boolean checkIfUserInputIsValid(String word) {
		char[] wordChar = word.toCharArray();

		if (wordChar.length > 1) {
			return false;
		}
		return true;
	}

	/*
	 * display current mock up word status to user so user knows which word(s) are
	 * matching
	 */
	private void displayWord() {
		String temp = "";
		for (int i = 0; i < _mockWordChar.length; i++) {
			temp = temp + _mockWordChar[i] + " ";
		}
		System.out.println(temp);
	}
}
