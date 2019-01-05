import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	enum Hands {
		ROCK, PAPER, SCISSOR;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean runQs = true;
		boolean startOver = true;
		String hand = "";
		Scanner reader = new Scanner(System.in);

		while (startOver) {
			while (runQs) {
				System.out.println("Please enter your hand:");

				hand = reader.nextLine();

				if (!isValidHand(hand.toUpperCase())) {
					System.out.println(hand + " is an invalid hand.");
					System.out.println("Please choose one of \"Rock, Paper, Scissor\".");
					System.out.println();
				} else {
					runQs = false;
				}
			}

			String computerHand = getRandomComputerHand();
			String result = getWinner(hand.toUpperCase(), computerHand);

			System.out.println("Your hand:" + hand);
			System.out.println("Computer's hand:" + computerHand);
			System.out.println("Result:" + result);
			runQs = true;
			
			System.out.println("Continue playing (y/n)?");
			String temp = reader.nextLine(); 
			startOver = temp.toUpperCase().equals("Y") ? true : false;
			System.out.println("");
		}
		reader.close();
		System.out.println("Thank you for playing.");
	}

	private static String getRandomComputerHand() {
		Random randNumGenerator = new Random();
		int randNum = randNumGenerator.nextInt(3); // Give me a random number between 0 (inclusive) and 3 (exclusive) ->
													// 0, 1, or 2
		return Hands.values()[randNum].toString();
	}

	private static boolean isValidHand(String hand) {
		for (Hands c : Hands.values()) {
			if (c.name().equals(hand)) {
				return true;
			}
		}
		return false;
	}

	private static String getWinner(String userHand, String computerHand) {
		String result = "";

		if (userHand.equals(computerHand)) {
			result = "Even";
		} else if (doesUserWin(userHand, computerHand)) {
			result = "You WIN";
		} else {
			result = "You LOST";
		}

		return result;
	}

	private static boolean doesUserWin(String userHand, String computerHand) {
		return (userHand.equals("ROCK") && computerHand.equals("SCISSOR"))
				|| (userHand.equals("SCISSOR") && computerHand.equals("PAPER"))
				|| (userHand.equals("PAPER") && computerHand.equals("ROCK"));
	}
}