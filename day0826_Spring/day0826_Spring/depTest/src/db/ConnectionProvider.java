package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();			 
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/oracle");
			conn = ds.getConnection();			
		}catch (Exception e) {
			e.printStackTrace();			
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
