package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

		String forwardPath=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardPath="/WEB-INF/view/form.jsp";
		String mode=request.getParameter("mode");
		if(mode!=null) {
			forwardPath="/WEB-INF/view/send.jsp";
			HttpSession session=request.getSession();
			session.invalidate();
		}
			RequestDispatcher rd=request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String massage=request.getParameter("massage");

		User user=new User(name,email,massage);

		HttpSession session=request.getSession();
		session.setAttribute("User",user);

		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/conform.jsp");
		rd.forward(request,response);
	}

}
