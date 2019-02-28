import java.util.List;
import java.util.Scanner;

public class ConsoleUtils {
	/*
	 * Prints a list of TimesheetEntry objects in a pretty table
	 */
	public void printList(List<ToDoItem> entries) {
		int longestItemDescription = 16;

		for (ToDoItem entry : entries) {
			if (entry.getDescription().length() > longestItemDescription) {
				longestItemDescription = entry.getDescription().length();
			}
		}

		String itemHeader = String.format("%" + longestItemDescription + "s", "Item Description");
		String itemUnderline = "";
		for (int i = 0; i < longestItemDescription; i++) {
			itemUnderline += "-";
		}

		System.out.println(" ID | " + itemHeader + " |    Status      ");
		System.out.println("----+-" + itemUnderline + "-+----------------");

		for (ToDoItem entry : entries) {
			String itemDescription = String.format("%-" + longestItemDescription + "s", entry.getDescription());
			String isCompleted = "";

			if (entry.getIsCompleted() == true) {
				isCompleted = "done";
			} else {
				isCompleted = "pending";
			}

			String line = String.format(" %2s | %s | %s ", entry.getId(), itemDescription, isCompleted);
			System.out.println(line);
		}

		if (entries.size() == 1) {
			System.out.println("[1 entry]");
		} else {
			System.out.println("[" + entries.size() + " entries]");
		}

		System.out.println();
	}

	/*
	 * Print all the options so users know what action options they can use to
	 * create this item list table
	 */
	public void printHelp() {
		System.out.println("Available functions: ");
		System.out.println("  add: 			to add an item");
		System.out.println("  delete: 		to delete an item");
		System.out.println("  mark done:    the item to mark as done");
		System.out.println("  list pending: to list the pending items");
		System.out.println("  list done:    to list the done items");
		System.out.println("  list all:	    to list all items");
		System.out.println("  help: 		display available functions");
		System.out.println("  quit: 		to quit");
		System.out.println();
	}

	/* Promote message to user and then expect user to enter a selection */
	public String promptMessageAndGetInput(String message, Scanner _reader) {
		System.out.println(message);
		return _reader.nextLine();
	}

	/* Promote message to user but do NOT expect user to enter a selection*/
	public void promptMessage(String message) {
		System.out.println(message);
		System.out.println();
	}
}
