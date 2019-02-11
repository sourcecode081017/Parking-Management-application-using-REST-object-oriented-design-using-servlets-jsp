
package Maverick_parking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Maverick_parking.data.UserSearchDAO;
import Maverick_parking.model.UserSearch;
import Maverick_parking.model.UserSearchResults;


@WebServlet("/UserSearchController")
public class UserSearchController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public UserSearchController()
{
	super();
	
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(request,response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	UserSearch user_search = new UserSearch();
	if(request.getParameter("btnSearch")!=null)
		try {
			{
				user_search.setPermitType(request.getParameter("permitType"));
				session.setAttribute("user_search", user_search);
				List<UserSearchResults> park_det = new ArrayList<UserSearchResults>();
				park_det = UserSearchDAO.searchPark(user_search);
				session.removeAttribute("user_search");
				session.setAttribute("parkdet", park_det);
				getServletContext().getRequestDispatcher("/userSearchResults.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}