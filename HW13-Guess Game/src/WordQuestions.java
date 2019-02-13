import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Random;

public class WordQuestions {
	String[] words = new String[0];

	public WordQuestions(String filePath) {
		// TODO Auto-generated constructor stub
		readToStorage(filePath);
	}

	public String pickAWord() {
		String question = getARandomWord();
		displayWordStatus(question);
		return question;
	}

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

	private void readLineToStorage(String line) {
		String[] temp = line.split(",");
		temp = removeExtraSpace(temp);
		int wordOriginalSize = words.length;
		resizeWordsArray(temp.length + wordOriginalSize);
		addWordsToArray(temp, wordOriginalSize);
	}

	private String[] removeExtraSpace(String[] temp) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].trim();
		}

		return temp;
	}

	private void addWordsToArray(String[] temp, int startPos) {
		for (int i = 0; i < temp.length; i++) {
			words[startPos + i] = temp[i];
		}
	}

	private String getARandomWord() {
		return words[getRandomNum(words.length)];
	}

	private void resizeWordsArray(int wordSize) {
		String[] temp = words;
		words = new String[wordSize];
		addWordsToArray(temp, 0);
	}

	private int getRandomNum(int numberOfQs) {
		Random randNumGenerator = new Random();
		return randNumGenerator.nextInt(numberOfQs);
	}

	private void displayWordStatus(String question) {
		char[] wordCharArray = question.toCharArray();
		System.out.println(String.join("", Collections.nCopies(wordCharArray.length, "_ ")));
	}
}
