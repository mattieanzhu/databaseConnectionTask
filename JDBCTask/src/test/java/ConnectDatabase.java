import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

public class ConnectDatabase {
	static String databaseName = "";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName;
	static String username = "root";
	static String password = "root";
	
	@Test
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String fName = "";
		String lName = "";
		String school = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", username, password);
		System.out.println(connection);
		PreparedStatement ps = connection.prepareStatement("SELECT FirstName, LastName, School FROM StudentTable");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			fName = rs.getString("FirstName");
			lName = rs.getString("LastName");
			school = rs.getString("School");
		}
		assertEquals(fName, "Anzhu");
		assertEquals(lName, "Mattie");
		assertEquals(school, "Hunter");
		if(connection != null) {
			connection.close();
		}
	}
	
}
