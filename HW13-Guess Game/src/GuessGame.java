
public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordQuestions wordQuestions = new WordQuestions("Questions.txt");
		String question = wordQuestions.pickAWord();
		Player player = new Player(question);
		player.PlayGame();
	}

}
