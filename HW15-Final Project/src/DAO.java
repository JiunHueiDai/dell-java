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

	public void create() {

		try {
			statement.executeUpdate("drop table if exists itemList");
			statement.executeUpdate("create table itemList(id integer, description string, isCompleted boolean)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void markDone(int itemId) {
		try {
			ToDoItem item = getItem(itemId);
			if (item == null) {
				System.out.println("The id " + itemId + " doesn't exit");
			} else {
				String queryString = "UPDATE itemList SET isCompleted = true where id = " + itemId;
				statement.executeUpdate(queryString);
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void delete(int itemId) {
		try {
			ToDoItem item = getItem(itemId);
			if (item == null) {
				System.out.println("The id " + itemId + " doesn't exit");
			} else {
				statement.executeUpdate("DELETE FROM itemList WHERE id = " + Integer.toString(itemId));
				System.out.println("id:        :" + item._id);
				System.out.println("description:" + item._description);
				System.out.println("status     :" + item._isCompleted);
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ToDoItem getItem(int itemId) {
		ToDoItem foundItem = null;

		try {
			ResultSet rs = statement.executeQuery("select * from itemList where id = " + Integer.toString(itemId));
			int id = -1;
			String description = "";
			boolean isCompleted = false;

			while (rs.next()) {
				// read the result set
				id = rs.getInt("id");
				description = rs.getString("description");
				isCompleted = rs.getBoolean("isCompleted");
				foundItem = new ToDoItem(id, description, isCompleted);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundItem;
	}

	public List<ToDoItem> list(String status) {
		List<ToDoItem> _list = new ArrayList<>();

		try {
			String query = "select * from itemList ";

			if (status == "done") {
				query = query + "where isCompleted = 1";
			} else if (status == "pending") {
				query = query + "where isCompleted = 0";
			}

			ResultSet rs = statement.executeQuery(query);
			int id = -1;
			String description = "";
			boolean isCompleted = false;

			while (rs.next()) {
				// read the result set
				id = rs.getInt("id");
				description = rs.getString("description");
				isCompleted = rs.getBoolean("isCompleted");
				_list.add(new ToDoItem(id, description, isCompleted));
			}

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return _list;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
