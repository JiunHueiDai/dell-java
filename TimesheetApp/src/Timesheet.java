import java.util.List;
import java.util.ArrayList;

public class Timesheet {
	private List<TimesheetEntry> database;

	public Timesheet() {
		database = new ArrayList<>();
	}

	/* Add new timesheet entry to the database */
	public void add(String project, String description) {
		TimesheetEntry myEntry = new TimesheetEntry(project, description);
		database.add(myEntry);
	}

	/*
	 * activeOnly will return timesheet entry that the endtime is equal to null name
	 * will return all the timesheet entry with the same project name
	 */
	public List<TimesheetEntry> list(boolean activeOnly, String name) {
		List<TimesheetEntry> result = database;

		if (activeOnly == true && name == null) {
			result = getActiveEntry();
		} else if (activeOnly == true && name != null) {
			List<TimesheetEntry> activeEntries = getActiveEntry();
			result = getMatchingNameEntries(activeEntries, name);
		} else if (activeOnly == false && name != null) {
			result = getMatchingNameEntries(database, name);
		}

		return result;
	}

	/* return all the matching project name subset from the passed in entries */
	private List<TimesheetEntry> getMatchingNameEntries(List<TimesheetEntry> entries, String name) {
		List<TimesheetEntry> tempTimesheet = new ArrayList<>();

		for (TimesheetEntry entry : entries) {
			if (entry.getProjectName().equals(name)) {
				tempTimesheet.add(entry);
			}
		}

		return tempTimesheet;
	}

	/* return all the entries with incomplete endtime */
	private List<TimesheetEntry> getActiveEntry() {
		List<TimesheetEntry> tempTimesheet = new ArrayList<>();

		for (TimesheetEntry entry : database) {
			if (entry.getEndTime() == null) {
				tempTimesheet.add(entry);
			}
		}

		return tempTimesheet;

	}

	/* get the entry with matching passed in id */
	public TimesheetEntry get(int id) {
		for (TimesheetEntry entry : database) {
			if (entry.getId() == id) {
				return entry;
			}
		}

		return null;
	}

	/* delete the entry from the database */
	public void delete(TimesheetEntry entry) {
		database.remove(entry);
	}

	/* set the endtime to now */
	public void stop(TimesheetEntry entry) {
		entry.updateEndTime();
	}
}
