package primieri.leonardo.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class TestConnection {

	@Test
	public void test() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/blog?user=root&password=root");
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		assertNotNull(conn);
	}

}
