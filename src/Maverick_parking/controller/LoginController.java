package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.model.Login;
import Maverick_parking.model.LoginErrorMsgs;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Login login = new Login();
		if(request.getParameter("btnLogin")!=null){
			login.setUserName(request.getParameter("userName"));
			login.setPassword(request.getParameter("password"));
			LoginErrorMsgs errorMsgs = new LoginErrorMsgs();
			login.validateUserNamePassword(login, errorMsgs);
			session.setAttribute("login",login);
			session.setAttribute("errorMsgs", errorMsgs);
			if(errorMsgs.getUserNamePasswordError().equals("")){
				String roleType = login.getRoleType(login);
				if(roleType.equals("User")){
					
				}
				else if(roleType.equals("Manager")){
					
				}
				else if(roleType.equals("Admin")){
					
				}
				else{
					
				}
			}
			else{
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				session.removeAttribute("errorMsgs");
			}
			
		}
	}

}
