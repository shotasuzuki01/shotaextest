package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Slime;

@WebServlet("/SlimeApp")
public class SlimeApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SlimeApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Slime slime=new Slime("すらきち",100);
		List<Slime>list=new ArrayList<>();
		list.add(new Slime("すらきち",100));
		list.add(new Slime("すらりん",89));
		list.add(new Slime("すらまる",92));
		request.setAttribute("skey",list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
