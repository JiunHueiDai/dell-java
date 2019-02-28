
public class ToDoItem {

	int _id;
	String _description;
	boolean _isCompleted;

	// Class Constructor to initial properties
	public ToDoItem(int id, String description, boolean isCompleted) {
		_id = id;
		_description = description;
		_isCompleted = isCompleted;
	}

	// Getter for Id
	public int getId() {
		return _id;
	}

	// Getter for description
	public String getDescription() {
		return _description;
	}

	// Getter for ssCompeted
	public boolean getIsCompleted() {
		return _isCompleted;
	}

}
