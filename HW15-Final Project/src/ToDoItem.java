
public class ToDoItem {

	int _id;
	String _description;
	boolean _isCompleted;

	public ToDoItem(int id,  String description, boolean isCompleted) {
		_id = id;
		_description = description;
		_isCompleted = isCompleted;
	}
	
	public int getId() {
		return _id;
	}

	public String getDescription() {
		return _description;
	}

	public boolean getIsCompleted() {
		return _isCompleted;
	}

}
