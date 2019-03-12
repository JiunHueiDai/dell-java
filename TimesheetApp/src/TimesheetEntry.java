import java.time.LocalDateTime;

public class TimesheetEntry {
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private static int NEXTID = 1;

	public TimesheetEntry(String myProject, String myTask) {
		projectName = myProject;
		task = myTask;
		startTime = LocalDateTime.now();
		id = NEXTID;
		NEXTID++;
	}

	/* getter for project name */
	public String getProjectName() {
		return projectName;
	}

	/* getter for task */
	public String getTask() {
		return task;
	}

	/* getter for id */
	public int getId() {
		return id;
	}

	/* getter for startTime */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/* getter for endtime */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/* set endtime to be current time */
	public void updateEndTime() {
		if (endTime == null) {
			endTime = LocalDateTime.now();
		}else
		{
			throw new RuntimeException();
		}
	}
}
