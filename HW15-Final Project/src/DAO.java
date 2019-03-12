import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	Connection connection = null;
	Statement statement = null;
	private int _id = 0;

	/*
	 * Class constructor to initialize connection object and connection with
	 * Database
	 */
	public DAO() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:ToDoItems.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 second.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * When controller starts, it calls create method to create a table in the
	 * database
	 */
	public void create() {

		try {
			statement.executeUpdate("drop table if exists itemList");
			statement.executeUpdate("create table itemList(id integer, description string, isCompleted boolean)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Mark an inputed item id in the itemList table as done/completed if the item
	 * id isn't found, return false to user to notice that the item id isn't marked
	 * as done in the database
	 */
	public boolean markDone(int itemId) {
		boolean markedSuccess = false;
		try {
			ToDoItem item = getItem(itemId);
			if (item != null) {
				String queryString = "UPDATE itemList SET isCompleted = true where id = " + itemId;
				statement.executeUpdate(queryString);
				markedSuccess = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return markedSuccess;
	}

	public void add(String description) {
		try {
			_id++;
			String queryString = "insert into itemList values(" + _id + ", \"" + description + "\", false)";
			statement.executeUpdate(queryString);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Delete an inputed item id in the itemList table if the item id isn't found,
	 * return false to user to notice that the item id isn't deleted in the database
	 */
	public boolean delete(int itemId) {
		boolean deletedSuccess = false;
		String status = "";
		try {
			ToDoItem item = getItem(itemId);
			if (item != null) {
				statement.executeUpdate("DELETE FROM itemList WHERE id = " + Integer.toString(itemId));
				if (item.getIsCompleted() == true) {
					status = "done";
				} else {
					status = "pending";
				}
				System.out.println("id:        :" + item._id);
				System.out.println("description:" + item._description);
				System.out.println("status     :" + status);
				deletedSuccess = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deletedSuccess;
	}

	/* Get the single all properties of the single item if the item exists */
	private ToDoItem getItem(int itemId) {
		String query = "select * from itemList where id = " + Integer.toString(itemId);

		List<ToDoItem> item = getItems(query);
		if (item == null || item.size() == 0) {
			return null;
		}

		return item.get(0);
	}

	/*
	 * Get the requested item list back to user User can request as "all", "pending"
	 * (isCompleted = false), "done" (isCompleted = true)
	 */
	public List<ToDoItem> list(String status) {
		String query = "select * from itemList ";

		if (status == "done") {
			query = query + "where isCompleted = 1";
		} else if (status == "pending") {
			query = query + "where isCompleted = 0";
		}

		return getItems(query);
	}

	/*
	 * Common method to loop through result set from execute query and then return
	 * the item array list
	 */
	private List<ToDoItem> getItems(String query) {
		List<ToDoItem> result = new ArrayList<ToDoItem>();

		try {
			ResultSet rs = statement.executeQuery(query);
			int id = -1;
			String description = "";
			boolean isCompleted = false;

			while (rs.next()) {
				// read the result set
				id = rs.getInt("id");
				description = rs.getString("description");
				isCompleted = rs.getBoolean("isCompleted");
				result.add(new ToDoItem(id, description, isCompleted));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// Close connection to database so it will not have memory leak in the future
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
