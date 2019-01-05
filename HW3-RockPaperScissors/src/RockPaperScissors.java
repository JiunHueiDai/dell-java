import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class RockPaperScissors {

	enum Hands {
		ROCK, PAPER, SCISSOR;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter your hand:");
		Scanner reader = new Scanner(System.in);
		String hand = reader.nextLine();

		if (isValidHand(hand)) {
			System.out.println(hand + " is an invalid hand.");
			System.out.println("Please choose one of \"Rock, Paper, Scissor \".");
			return;
		}

		
		String computerHand = getRandomComputerHand();
		String result = getWinner(hand.toUpperCase(), computerHand);

		System.out.println("Your hand:" + hand);
		System.out.println("Computer's hand:" + computerHand);
		System.out.println("Result:" + result);
	}

	private static String getRandomComputerHand() {
		Random randNumGenerator = new Random();
		int randNum = randNumGenerator.nextInt(3); // Give me a random number between 0 (inclusive) and 3 (exclusive) ->
													// 0, 1, or 2
		return Hands.values()[randNum].toString();
	}

	private static boolean isValidHand(String hand) {
		return Hands.valueOf(hand.toUpperCase()).ordinal() > 0 ? true : false;
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