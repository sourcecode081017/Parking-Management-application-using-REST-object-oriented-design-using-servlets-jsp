package Maverick_parking.model;
import java.io.Serializable;
import java.sql.SQLException;

import Maverick_parking.data.AdminSearchDAO;

public class AdminSearch implements Serializable {

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
		
		public void validate(AdminSearch admin,AdminSearchErrorMsgs admin_error) throws SQLException{
			String errmsg ="";
			if(!AdminSearchDAO.exist(admin))
			{
				errmsg = "The username does not exist";
			}
			admin_error.setUserNameError(errmsg);
		}
		
	}


