import java.time.LocalDateTime;

public class ToDoItem {

	int _id;
	String _name;
	String _description;
	LocalDateTime _dueDate;
	boolean _isCompleted;

	public ToDoItem(int id, String name, String description, LocalDateTime dueDate, boolean isCompleted) {
		_id = id;
		_name = name;
		_description = description;
		_dueDate = dueDate;
		_isCompleted = isCompleted;
	}
	
	public int getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}

	public LocalDateTime getDueDate() {
		return _dueDate;
	}

	public boolean isCompletedFlag() {
		return _isCompleted;
	}

}
