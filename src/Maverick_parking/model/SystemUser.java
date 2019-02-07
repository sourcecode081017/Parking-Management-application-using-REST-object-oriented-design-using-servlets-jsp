package Maverick_parking.model;

import java.io.Serializable;

public class SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String name;
	private String roleType;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}


}
