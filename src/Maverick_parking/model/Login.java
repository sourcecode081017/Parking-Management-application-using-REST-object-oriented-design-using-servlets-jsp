package Maverick_parking.model;

import Maverick_parking.data.SystemUserDAO;

public class Login {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void validateUserNamePassword(Login login,LoginErrorMsgs errorMsgs){
		String res = "";
		String un = login.getUserName();
		String pass = login.getPassword();
		if(un.equals("")||pass.equals("")){
			res = "The User Name or password field cannot be empty";
		}
		else if(!SystemUserDAO.validateLoginCredentials(un, pass)){
			res = "The User Name and (or) Password do not match";
		}
		errorMsgs.setUserNamePasswordError(res);
	}
	//Call this method from controller only after previous method
	public String getRoleType(Login login){
		String un = login.getUserName();
		String roleType = SystemUserDAO.getRoleTypeFromDb(un);
		return roleType;
	}
	

}
