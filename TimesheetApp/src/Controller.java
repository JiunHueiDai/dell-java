import java.util.List;

public class Controller {

	/* Member variables */

	Timesheet timesheet;
	ConsoleUtils consoleUtils;

	/* Constructor */

	public Controller() {
		this.timesheet = new Timesheet();
		this.consoleUtils = new ConsoleUtils();
	}

	/* Methods */

	/*
	 * Runs the program
	 */
	public void start() {

		consoleUtils.printHelp(); // Print the action menu

		boolean quit = false;
		while (!quit) {

			// Prompt the user for input, collect input, parse into parts
			String input = consoleUtils.promptString("> ");
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
			if (action.equals("add")) {

				processAddAction();

			} else if (action.equals("delete")) {

				processDeleteAction(actionParts);

			} else if (action.equals("stop")) {

				processStopAction(actionParts);

			} else if (action.equals("list")) {

				processListAction(actionParts);

			} else if (action.equals("quit")) {

				quit = true;

			} else if (action.equals("help")) {

				consoleUtils.printHelp();

			} else if (action.length() == 0) {

				// do nothing.

			} else {
				consoleUtils.error("Invalid action");
			}
		}

	}

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as
	 * complete) This method conveys that request to the Timesheet
	 */
	public void processStopAction(String[] actionParts) {

		if (actionParts.length > 2) {
			consoleUtils.error("Too many inputs to stop command");
			return;
		}

		try {
			int id = Integer.parseInt(actionParts[1]);
			TimesheetEntry myEntry = timesheet.get(id);

			if (myEntry != null) {

				try {
					timesheet.stop(myEntry);
					consoleUtils.info("Entry stopped");
				} catch (Exception e) {
					consoleUtils.error("Stop command failed, was entry already stopped?");
				}

			} else {
				consoleUtils.error("Could not find entry with id " + id);
			}
		} catch (Exception e) {
			consoleUtils.error("Stop command requires a valid integer id");
		}

	}

	/*
	 * The user requested that a given TimesheetEntry be deleted This method conveys
	 * that request to the Timesheet
	 */
	public void processDeleteAction(String[] actionParts) {

		if (actionParts.length > 2) {
			consoleUtils.error("Too many inputs to delete command");
			return;
		}

		try {
			int id = Integer.parseInt(actionParts[1]);
			TimesheetEntry myEntry = timesheet.get(id);

			if (myEntry != null) {
				timesheet.delete(myEntry);
				consoleUtils.info("Entry deleted");
			} else {
				consoleUtils.error("Could not find entry with id " + id);
			}
		} catch (Exception e) {
			consoleUtils.error("Delete command requires a valid integer id");
		}
	}

	/*
	 * The user wants to view a list of timesheet entries This method conveys that
	 * request to the Timesheet, along with any special options (active-only, filter
	 * by project name)
	 */
	public void processListAction(String[] actionParts) {

		if (actionParts.length > 3) {
			consoleUtils.error("Too many inputs to list command");
			return;
		}

		boolean activeOnly = false;
		String name = null;

		switch (actionParts.length) {
		case 2:
			if (actionParts[1].equals("-a")) {
				activeOnly = true;
			} else {
				name = actionParts[1];
			}
			break;
		case 3:
			activeOnly = true;

			if (actionParts[1].equals("-a")) {
				name = actionParts[2];
			} else {
				name = actionParts[1];
			}

			break;
		default:

		}

		consoleUtils.printList(timesheet.list(activeOnly, name));
	}

	/*
	 * The user wants to add a new entry to the Timesheet This method conveys that
	 * request to the Timesheet, along with the specified project name and task
	 * description
	 */
	public void processAddAction() {

		String project = consoleUtils.promptString("Project Name (one word only):");
		String description = consoleUtils.promptString("Task:");

		if (isValidProjectName(project)) {
			timesheet.add(project, description);
			consoleUtils.info("Entry added");
		} else {
			consoleUtils.error(
					"A project is required. \nThe project and the task description aren't added because project name is invalid. \nPlease provide one-word-only project name (no space in the between).");
		}
	}

	/* Check if project name is one word only */
	private boolean isValidProjectName(String project) {
		if (project.trim().equals("")) {
			return false;
		}

		String[] arrProjectName = project.split(" ");

		if (arrProjectName.length != 1) {
			return false;
		}
		return true;
	}
}