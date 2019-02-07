package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.SystemUser;

/**
 * Servlet implementation class SystemUserController
 */
@WebServlet("/SystemUserController")
public class SystemUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemUserController() {
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
		SystemUser systemUser = new SystemUser();
		if(request.getParameter("btnRegister")!=null){
		systemUser.setUserName(request.getParameter("userName"));
		systemUser.setPassword(request.getParameter("password"));
		systemUser.setName(request.getParameter("name"));
		systemUser.setRoleType(request.getParameter("roleType"));
		session.setAttribute("systemUser", systemUser);
		SystemUserDAO.insertUser(systemUser);
		session.removeAttribute("systemUser");
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
