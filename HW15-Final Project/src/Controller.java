import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

	private DAO _dao = new DAO();
	private ConsoleUtils _utils = new ConsoleUtils();
	Scanner _reader = new Scanner(System.in);

	/* Start the actions */
	public void start() {
		_utils.printHelp();
		_dao.create();
		boolean continueAction = true;
		while (continueAction) {
			String input = _utils.promptMessageAndGetInput("Please select an option:", _reader);
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

				_utils.printHelp();

			} else if (action.length() == 0) {

				// do nothing.

			} else {
				_utils.promptMessage("[ERROR] Invalid action]");
			}
		}
		_reader.close();

	}

	// when quitting this application, it should close connections
	private void processQuitAction() {
		_dao.closeConnection();
	}

	/*
	 * list all: list all items in the table list pending: only list the items that
	 * haven't been completed list done: only list the items that have been
	 * completed any other options in the list will be an invalid list action
	 */
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
			_utils.promptMessage("[ERROR] Invalid list action");
			print = false;
		}

		if (print == true) {
			_utils.printList(_list);
		}
	}

	/*
	 * Delete an item from id that user inputs. If user provides an empty space, it
	 * will consider invalid id.
	 */
	private void processDeleteAction() {
		try {
			int itemId = Integer.parseInt(_utils.promptMessageAndGetInput("Enter an item id:", _reader));

			boolean deletedSuccess = _dao.delete(itemId);
			if (deletedSuccess) {
				_utils.promptMessage("[item delete]");
			} else {
				_utils.promptMessage("[ERROR] Could not find the item with Id: " + itemId);
			}
		} catch (Exception e) {
			_utils.promptMessage("[ERROR] Invalid Id");
		}
	}

	/*
	 * Mark an item as done/completed by the item id that user provides. If user
	 * provides an empty space, it will consider invalid id.
	 */
	private void processMarkDoneAction() {
		try {
			int itemId = Integer.parseInt(_utils.promptMessageAndGetInput("Enter an item id:", _reader));
			boolean markedSuccess = _dao.markDone(itemId);
			if (markedSuccess) {
				_utils.promptMessage("[item updated]");
			} else {
				_utils.promptMessage("[ERROR] Could not find the item with Id: " + itemId);
			}
		} catch (Exception e) {
			_utils.promptMessage("[ERROR] Invalid Id");
		}
	}

	/* Add an item description with an automatically increased item id */
	private void processAddAction() {
		String description = _utils.promptMessageAndGetInput("Item Description: ", _reader);
		_dao.add(description);
		_utils.promptMessage("[Item added]");
	}
}
