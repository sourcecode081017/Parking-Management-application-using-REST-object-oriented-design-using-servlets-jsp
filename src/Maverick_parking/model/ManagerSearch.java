package Maverick_parking.model;

import java.io.Serializable;
import java.sql.SQLException;

import Maverick_parking.data.ManagerSearchDAO;

public class ManagerSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uname = "";
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void validate(ManagerSearch manager,ManagerSearchErrorMsgs manager_error) throws SQLException{
		String errmsg ="";
		if(!ManagerSearchDAO.exist(manager))
		{
			errmsg = "The username does not exist";
		}
		manager_error.setUserNameError(errmsg);
	}
	
	
}
