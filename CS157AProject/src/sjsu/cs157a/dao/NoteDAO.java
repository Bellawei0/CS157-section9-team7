package sjsu.cs157a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sjsu.cs157a.config.DatabaseConnection;
import sjsu.cs157a.model.Note;

/**
 * 
 * @author
 *
 */
public class NoteDAO implements DAOInterface<Note> {

	private static DatabaseConnection databaseConnection = new DatabaseConnection();
	private static Connection connection;

	public NoteDAO(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	protected static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = databaseConnection.initializeConnection();
		return connection;

	}

	@Override
	public boolean insert(Note t) throws SQLException, ClassNotFoundException {
//		String INSERT_NOTES_SQL = "INSERT INTO note_meta" + " (note_id, title, content) VALUES " + " (?, ?,?);";
//		System.out.println("Debug in NoteDao INSERT_NOTES_SQL: " + INSERT_NOTES_SQL);
//		databaseConnection.executeUpdate(INSERT_NOTES_SQL, t.getTitle(), t.getContent());
		return false;
	}
	
	// Insert a note
		public void insertNote(Note note) throws SQLException, ClassNotFoundException {
			String INSERT_NOTES_SQL = "INSERT INTO note_meta" + " (title, content) VALUES " + " (?,?);";
			System.out.println(INSERT_NOTES_SQL);
			connection = getConnection();
			try (
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTES_SQL)) {
				preparedStatement.setString(1, note.getTitle());
				preparedStatement.setString(2, note.getContent());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	
	

	@Override
	public List<Note> listAll() throws SQLException, ClassNotFoundException {
		// Create a list to hold notes
		List<Note> noteList = new ArrayList<>();

		// Step 1: Establishing a connection
		connection = getConnection();
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM project157a.note_meta");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("note_id");
				String title = rs.getString("title");
				String content = rs.getNString("content");
				noteList.add(new Note(id, title, content));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);

		}
		return noteList;

	}

	@Override
	public Note getById(String id) throws SQLException, ClassNotFoundException {
		return null;
	}
	
	// Select notes
		public Note selectNote(int id) throws ClassNotFoundException, SQLException {
			String SELECT_NOTES_BY_ID = "select principle_id, note_id, title, content from users where note_id =?";
			Note note = null;
			connection = getConnection();
			// Step 1: Establishing a Connection
			try (
					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTES_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int note_id = rs.getInt("note_id");
					String title = rs.getString("title");
					String content = rs.getNString("content");

					note = new Note(note_id, title, content);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			return note;
		}
	

	@Override
	public boolean update(Note t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO: update 
		public boolean updateNote(Note note) throws SQLException, ClassNotFoundException {
			String UPDATE_NOTES_SQL = "update note_meta set principle_id = ?, note_id= ?, title =?, content =? where note_id = ?;";
			boolean rowUpdated;
			connection = getConnection();
			
			try (
				PreparedStatement statement = connection.prepareStatement(UPDATE_NOTES_SQL);) {
				statement.setInt(1, note.getNote_id());
				statement.setString(2, note.getTitle());
				statement.setString(3, note.getContent());
				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
	
	// detele 
	public boolean deleteNote(int id) throws SQLException, ClassNotFoundException {
		String DELETE_NOTES_SQL = "delete from note_meta where note_id = ?;";
			boolean rowDeleted;
			
			connection = getConnection();
			try (
					PreparedStatement statement = connection.prepareStatement(DELETE_NOTES_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		

	@Override
	public boolean delete(Note t) {
		// TODO Auto-generated method stub
		return false;
	}
	

	// --------------- This main class for testing ----------
	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		// System.out.println("data"+ databaseConnection);
		List<Note> nodeList = new ArrayList<>();

		// System.out.println("debug " + connection);
		connection = getConnection();
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM project157a.note_meta");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getNString("content");
				nodeList.add(new Note(title, content));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);

		}

		System.out.println("debug in main:" + nodeList);
	}

}
