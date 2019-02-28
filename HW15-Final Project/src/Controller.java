import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	private Scanner _reader;
	private DAO _dao = new DAO();

	public void start() {
		_reader = new Scanner(System.in);
		_dao.create();
		printHelp();
		boolean continueAction = true;
		while (continueAction) {
			String input = promptMessageAndGetInput("Please select an option:");
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
			if (action.equals("add")) {

				processAddAction();

			} else if (action.equals("delete")) {

				processDeleteAction();

			} else if (action.equals("mark")) {

				processMarkDoneAction();

			} else if (action.equals("list")) {

				processListAction(actionParts);

			} else if (action.equals("quit")) {
				
				processQuitAction();
				continueAction = false;

			} else if (action.equals("help")) {

				printHelp();

			} else if (action.length() == 0) {

				// do nothing.

			} else {
				promptMessage("[Error: Invalid action]");
			}
		}
		_reader.close();

	}

	private void processQuitAction() {
		_dao.closeConnection();
	}
	
	private void processListAction(String[] actionParts) {
		List<ToDoItem> _list = new ArrayList<>();
		boolean print = true;
		if (actionParts[1].equals("all")) {
			_list = _dao.list("all");
		} else if (actionParts[1].equals("done")) {
			_list = _dao.list("done");
		} else if (actionParts[1].equals("pending")) {
			_list = _dao.list("pending");
		} else {
			promptMessage("[Error: Invalid list action]");
			print = false;
		}
		
		if(print == true) {
			printList(_list);
		}
	}

	private void processDeleteAction() {
		int itemId = Integer.parseInt(promptMessageAndGetInput("Enter an item id:"));
		_dao.delete(itemId);
		promptMessage("[item delete]");
	}

	private void processMarkDoneAction() {
		int itemId = Integer.parseInt(promptMessageAndGetInput("Enter an item id:"));
		_dao.markDone(itemId);
	}

	private String promptMessageAndGetInput(String message) {
		System.out.println(message);
		return _reader.nextLine();
	}

	private void promptMessage(String message) {
		System.out.println(message);
		System.out.println();
	}

	private void processAddAction() {
		String description = promptMessageAndGetInput("Item Description: ");
		_dao.add(description);
		promptMessage("[Entry added]");
	}

	private void printHelp() {
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
	
	/*
	 * Prints a list of TimesheetEntry objects in a pretty table
	 */
    public void printList(List<ToDoItem> entries){
        int longestItemDescription =  16;
        
        for(ToDoItem entry : entries){
            if(entry.getDescription().length() > longestItemDescription) {
            	longestItemDescription = entry.getDescription().length();
            }
        }

        String itemHeader = String.format("%"+longestItemDescription+"s", "Item Description");
        String itemUnderline = "";
        for(int i=0;i<longestItemDescription;i++){
            itemUnderline+="-";
        }

        System.out.println(" ID | "+ itemHeader   +" | IsCompleted    ");
        System.out.println("----+-"+ itemUnderline+"-+----------------");

        for(ToDoItem entry : entries){
            String itemDescription = String.format("%-"+longestItemDescription+"s", entry.getDescription());
            String isCompleted = Boolean.toString(entry.getIsCompleted());

            String line = String.format(" %2s | %s | %s ", entry.getId(), itemDescription, isCompleted);
            System.out.println(line);
        }

        if(entries.size() == 1){
            System.out.println("[1 entry]");
        } else {
            System.out.println("["+entries.size()+" entries]");
        }

        System.out.println();
    }
}
