import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private List<ToDoItem> _list;
	Statement statement = null;

	public DAO() {
		_list = new ArrayList<>();
		Connection connection = null;
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
			statement.executeUpdate(
					"create table itemList(id integer, name string, description string, dueDate date, isCompleted boolean)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			statement.executeUpdate("UPDATE itemList\r\n" + "SET name = new_value_1,\r\n"
					+ "    description = new_value_2,\r\n" + "    dueDate = new_value_3,\r\n"
					+ "    completed = new_value_4,\r\n" + "WHERE\r\n" + "    id = 1 \r\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add() {
		try {
			statement.executeUpdate("insert into itemList values(1, 'Wedding')");
			statement.executeUpdate("insert into itemList values(2, 'Send out invitation')");
			statement.executeUpdate("insert into itemList values(3, 'Check with speaker')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete() {
		try {
			statement.executeUpdate("DELETE FROM itemList WHERE id = 1;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<ToDoItem> list() {

		try {
			ResultSet rs = statement.executeQuery("select * from itemList");
			int id = -1;
			String name = "";
			String description = "";
			LocalDateTime dueDate = null;
			boolean isCompleted = false;
			
			while (rs.next()) {
				// read the result set
//			new ToDoItem();
				id = rs.getInt("id");
				name = rs.getString("name");
				description = rs.getString("description");
				dueDate = LocalDateTime.parse(rs.getString("dueDate"));
				isCompleted = Boolean.parseBoolean(rs.getString("isCompleted"));
				_list.add(new ToDoItem(id, name, description, dueDate, isCompleted));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
