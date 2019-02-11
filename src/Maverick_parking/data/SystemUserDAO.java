package Maverick_parking.data;

import java.sql.Connection;
import java.sql.ResultSet;
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
		String insertUserQuery = "INSERT INTO system_user (user_name,password,name,role_type) VALUES('"+systemUser.getUserName()
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
	public static boolean uniqueUserName(String userName){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT * FROM system_user WHERE user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			return rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return true;
	}
	public static boolean validateLoginCredentials(String userName,String password){
		Statement stmt = null;   
		Connection conn = null;
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT * FROM system_user WHERE user_name = '"+userName+"' AND password = '"+password+"'";
			ResultSet rs = stmt.executeQuery(query);
			return rs.next();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return false;
		
	}
	//This method to be called only after validating
	public static String getRoleTypeFromDb(String userName){
		Statement stmt = null;   
		Connection conn = null;
		String roleType = "";
		try{
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String query = "SELECT role_type FROM system_user WHERE user_name = '"+userName+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				roleType = rs.getString(1);
			}
		
	}
		catch(SQLException e){
			e.printStackTrace();
		}
     return roleType;
   }
}
