import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsWithTryCatch {

	enum Hands {
		ROCK, PAPER, SCISSOR;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame();
	}

	private static void playGame() {
		boolean startOver = true;
		//only use one reader so we don't need to create more than one same usage object
		Scanner reader = new Scanner(System.in);

		//if user wants to play more than one time, we can use while loop
		while (startOver) {
			String hand = getUserHand(reader);
			String computerHand = getRandomComputerHand();
			String result = getWinner(hand.toUpperCase(), computerHand);
			printGameResult(hand, computerHand, result);
			startOver = continuePlaying(reader);
		}
		reader.close();
		System.out.println("Thank you for playing.");
	}

	private static boolean continuePlaying(Scanner reader) {
		System.out.println("Continue playing (y/n)?");
		String moreGame = reader.nextLine();
		System.out.println("");

		// "Yes" (not case sensitive) won't continue the game. Answer has to be "Y"
		// Player has to provide "Y" (both lower case and upper case will continue the game)
		return moreGame.toUpperCase().equals("Y") ? true : false;
	}

	private static void printGameResult(String hand, String computerHand, String result) {
		System.out.println("Your hand:" + hand);
		System.out.println("Computer's hand:" + computerHand);
		System.out.println("Result:" + result);
	}

	private static String getUserHand(Scanner reader) {
		String hand = "";
		boolean runQs = true;

		while (runQs) {
			System.out.println("Please enter your hand:");
			hand = reader.nextLine();
			runQs = !isValidateUserHand(hand);
		}
		return hand;
	}

	private static boolean isValidateUserHand(String hand) {
		// Player has to provide one of three options, Rock, Paper, Scissor and case doesn't matter.
		// As long as player provides correct entire spelling and the player can play the game.
		// The option can't only first letter.
		try {
			hasValidHand(hand.toUpperCase());
			return true;
		} catch (Exception e) {
			System.out.println(hand + " is an invalid hand.");
			System.out.println("Please choose one of \"Rock, Paper, Scissor\".");
			System.out.println();
			return false;
		}
	}

	private static String getRandomComputerHand() {
		Random randNumGenerator = new Random();
		int randNum = randNumGenerator.nextInt(3); // Give me a random number between 0 (inclusive) and 3 (exclusive) -> 0, 1, or 2
		return Hands.values()[randNum].toString();
	}

	private static void hasValidHand(String hand) {
		boolean foundMatching = false;
		for (Hands c : Hands.values()) {
			if (c.name().equals(hand)) {
				foundMatching = true;
			}
		}
		
		// If player's hand doesn't match one of default three options, Rock, Paper, Scissor, it will throw exception.
		// Previous method will catch this exception and continue other code
		if(foundMatching == false)
			throw new StringIndexOutOfBoundsException();
	}

	private static String getWinner(String userHand, String computerHand) {
		String result = "";

		if (userHand.equals(computerHand)) {
			result = "Even.";
		} else if (doesUserWin(userHand, computerHand)) {
			result = "You WIN! :)";
		} else {
			result = "You LOST! :'(";
		}

		return result;
	}

	private static boolean doesUserWin(String userHand, String computerHand) {
		return (userHand.equals("ROCK") && computerHand.equals("SCISSOR"))
				|| (userHand.equals("SCISSOR") && computerHand.equals("PAPER"))
				|| (userHand.equals("PAPER") && computerHand.equals("ROCK"));
	}
}