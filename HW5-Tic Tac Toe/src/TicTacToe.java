import java.util.Scanner;

public class TicTacToe {
	static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
	static String playerTurn = "x";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean continueGame = true;
		Scanner reader = new Scanner(System.in);
		String hand = "";
		int numberOfHands = 0;

		while (continueGame) {
			displayBoard();
			System.out.println("Please enter your hand");
			hand = reader.nextLine().trim();
			

			if (isValidHand(hand)) {
				char[] xyChar = hand.toCharArray();
				int[] xy = { Integer.parseInt(Character.toString(xyChar[0])),
						Integer.parseInt(Character.toString(xyChar[1])) };

				placeHand(xy);
				numberOfHands++;
				boolean foundWinner = hasWinner(xy);
				if (foundWinner == true) {
					displayBoard();
					System.out.println("Congrats Winner user " + playerTurn);
					continueGame = false;
				} else if (numberOfHands == 9) {
					displayBoard();
					System.out.println("This is a tied game!");
					continueGame = false;
				}

			}
		}

		reader.close();
	}

	private static boolean isValidHand(String hand) {
		char[] xyChar = hand.toCharArray();
		try {
			Integer.parseInt(Character.toString(xyChar[0]));
			Integer.parseInt(Character.toString(xyChar[1]));
		} catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException nfe) {
			System.out.println(hand + " is not a valid hand. ");
			System.out.println("Please input a valid hand such as 00, 01, 10, or so on.");
			return false;
		}

		int[] xy = { Integer.parseInt(Character.toString(xyChar[0])),
				Integer.parseInt(Character.toString(xyChar[1])) };

		if (!isValidInput(xy)) {
			System.out.println(hand + " is not a valid hand. ");
			System.out.println("Please input a valid hand such as 00, 01, 10, or so on.");
			return false;
		}

		if (checkIfPosIsTaken(xy)) {
			System.out.println(hand + " has been taken. ");
			System.out.println("Please input another hand.");
			return false;
		}

		return true;
	}

	private static void placeHand(int[] xy) {
		board[xy[0]][xy[1]] = playerTurn;
	}

	private static boolean isValidInput(int[] xy) {
		if (xy.length != 2) {
			return false;
		}

		return true;
	}

	private static boolean checkIfPosIsTaken(int[] xy) {

		if (!board[xy[0]][xy[1]].equals(" ")) {
			return true;
		}

		return false;
	}

	private static void displayBoard() {
		System.out.println("    0     1     2  ");
		System.out.println(" 0  " + String.join("  |  ", board[0]));
		System.out.println("  -----------------");
		System.out.println(" 1  " + String.join("  |  ", board[1]));
		System.out.println("  -----------------");
		System.out.println(" 2  " + String.join("  |  ", board[2]));
	}

	private static boolean hasWinner(int[] xy) {
		if (hasHorizontalMatch(xy) || hasVerticalMatch(xy) || hasDiagonalMatch()) {
			return true;
		}
		playerTurn = playerTurn == "x" ? "o" : "x";
		return false;
	}

	private static boolean hasHorizontalMatch(int[] xy) {
		int x = xy[0];
		if (board[x][0].equals(board[x][1]) && board[x][1].equals(board[x][2]) && board[x][0].equals(playerTurn)) {
			return true;
		}
		return false;
	}

	private static boolean hasVerticalMatch(int[] xy) {
		int y = xy[1];
		if (board[0][y].equals(board[1][y]) && board[1][y].equals(board[2][y]) && board[y][0].equals(playerTurn)) {
			return true;
		}
		return false;
	}

	private static boolean hasDiagonalMatch() {
		if ((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals(playerTurn))
				|| (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])
						&& board[2][0].equals(playerTurn))) {
			return true;
		}
		return false;
	}
}