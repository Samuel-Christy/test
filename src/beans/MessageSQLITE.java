package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MessageSQLITE implements MessageStoreI {
	private static final String URL = "jdbc:sqlite:C:/Program Files (x86)/SQLiteStudio/maBase";
	private static final String READ = "SELECT * FROM tchat";
	private static final String WRITE = "INSERT INTO tchat (userName,content) VALUES (?,?)";

	public static void addMessage(MessageBean message) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {

			// La connexion
			con = DriverManager.getConnection(URL);
			stmt = con.prepareStatement(WRITE);
			stmt.setString(1, message.getUserName());
			stmt.setString(2, message.getContent());
			stmt.executeUpdate();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {
			// On ferme la connexion
			if (stmt != null) {
				try {
					stmt.close(); // Le stmt.close ferme automatiquement le
									// rset.
				} catch (final SQLException e1) {
					e1.printStackTrace();
				}
			} // Même chose pour con
		}
	}

	public static ArrayList<MessageBean> getMessage() {
		Connection con = null;
		Statement stmt = null;
		ArrayList<MessageBean> e = new ArrayList<>();
		try {

			// La connexion
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(URL);
			stmt = con.createStatement();
			// Lancer la requête ICI…
			ResultSet r = stmt.executeQuery(READ);

			while (r.next()) {
				MessageBean elv = new MessageBean(r.getString("userName"), r.getString("content"));
				e.add(elv);
			}

			return e;
		} catch (final Exception e1) {
			e1.printStackTrace();
		} finally {
			// On ferme la connexion
			if (stmt != null) {
				try {
					stmt.close(); // Le stmt.close ferme automatiquement le
									// rset.
				} catch (final SQLException e1) {
					e1.printStackTrace();
				}
			} // Même chose pour con
		}
		return e;
	}

	public static void main(String[] args) {
		System.out.println("MessageSQLITE.main()");
		addMessage("sam", "Hello world");
		addMessage("world", "Hello Sam");

		for (MessageBean m : getMessage()) {
			System.out.println(m.getUserName() + "\t:\t" + m.getContent());
		}

	}

	private static void addMessage(String string, String string2) {
		// TODO Auto-generated method stub
		addMessage(new MessageBean(string, string2));

	}

}
