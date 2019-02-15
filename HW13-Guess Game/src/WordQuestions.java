import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Random;

public class WordQuestions {
	String[] words = new String[0];

	/* class construction to read words in the file to the objects */
	public WordQuestions(String filePath) {
		// TODO Auto-generated constructor stub
		readToStorage(filePath);
	}

	/* randomly pick a word from all of the options */
	public String pickAWord() {
		String question = getARandomWord();
		displayWordStatus(question);
		return question;
	}

	/* read all the words in the given file */
	private void readToStorage(String filePath) {
		String line;

		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			while ((line = in.readLine()) != null) {
				readLineToStorage(line.toUpperCase());
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* read each line in the file and add them to an array */
	/* always create a new word array when read in each line */
	/*
	 * (it has another way to create a fixed array instead to save all the words as
	 * well.)
	 */
	private void readLineToStorage(String line) {
		String[] temp = line.split(",");
		temp = removeExtraSpace(temp);
		int wordOriginalSize = words.length;
		createWordsArray(temp.length + wordOriginalSize);
		addWordsToArray(temp, wordOriginalSize);
	}

	/* remove space before and after each word */
	private String[] removeExtraSpace(String[] temp) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].trim();
		}

		return temp;
	}

	/* add words in each line to word arrays/storage */
	private void addWordsToArray(String[] temp, int startPos) {
		for (int i = 0; i < temp.length; i++) {
			words[startPos + i] = temp[i];
		}
	}

	/* find the words in the word array as the question to user */
	private String getARandomWord() {
		return words[getRandomNum(words.length)];
	}

	/* create the same size of array with the guessing word */
	private void createWordsArray(int wordSize) {
		String[] temp = words;
		words = new String[wordSize];
		addWordsToArray(temp, 0);
	}

	/* get a random number */
	private int getRandomNum(int numberOfQs) {
		Random randNumGenerator = new Random();
		return randNumGenerator.nextInt(numberOfQs);
	}

	/* display underline for each charactor in the guess word */
	private void displayWordStatus(String question) {
		char[] wordCharArray = question.toCharArray();
		System.out.println(String.join("", Collections.nCopies(wordCharArray.length, "_ ")));
	}
}
