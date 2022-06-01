package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath=null;
		String action= request.getParameter("action");

		if(action==null) {
			forwardPath="/WEB-INF/jsp/registerForm.jsp";
		}else if(action.equals("done")) {
			HttpSession session=request.getSession();
			User registerUser=(User) session.getAttribute("registerUser");


		session.removeAttribute("registerUser");
		forwardPath="/WEB-INF/jsp/refisterDone.jsp";

		}
		RequestDispatcher dp=request.getRequestDispatcher(forwardPath);
		dp.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}