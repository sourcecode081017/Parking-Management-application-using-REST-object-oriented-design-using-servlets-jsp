package Maverick_parking.data;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Maverick_parking.model.SystemUser;
import Maverick_parking.util.SQLConnection;

public class SystemUserDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static void insertUser(SystemUser systemUser){
		Statement stmt = null;   
		Connection conn = DBMgr.getDBConnection();
		//Connection conn = null;
		String insertUserQuery = "INSERT INTO system_user VALUES('"+systemUser.getUserName()
		+"',"+"'"+systemUser.getPassword()+"',"+"'"+systemUser.getName()+"',"+"'"
				+systemUser.getRoleType()+"')";
		try { 
			 
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);   
			stmt = conn.createStatement();
			stmt.executeUpdate(insertUserQuery);
			conn.commit();					 
		}catch (SQLException sqle) { 
			sqle.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		
	}
	}

}
