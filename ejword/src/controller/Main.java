package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WordsDAO;
import model.Words;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int LIMIT=20;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchWord=(String)request.getParameter("searchWord");
		if(searchWord !=null) {
			String mode=(String)request.getParameter("mode");
			if(mode==null) {
				mode="starsWith";
			}
			String page=(String)request.getParameter("page");
			int pageNo=page==null? 1:Integer.parseInt(page);
			WordsDAO dao=new WordsDAO();
			int total=dao.getCount(searchWord, mode);
			List<Words> list=dao.getListBySearchWord(searchWord,mode,LIMIT,(pageNo-1)*LIMIT);
			request.setAttribute("total", total);
			request.setAttribute("limit", LIMIT);
			request.setAttribute("searchWord",searchWord);
			request.setAttribute("mode",mode);
			request.setAttribute("list",list);
			request.setAttribute("pageNo", pageNo);
		}
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/main.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchWord=request.getParameter("searchWord");
		String mode=(String)request.getParameter("mode");
		WordsDAO dao=new WordsDAO();
		int total=dao.getCount(searchWord, mode);
		List<Words> list=dao.getListBySearchWord(searchWord,mode,LIMIT);
		request.setAttribute("total", total);
		request.setAttribute("limit", LIMIT);
		request.setAttribute("searchWord",searchWord);
		request.setAttribute("mode",mode);
		request.setAttribute("list",list);
		doGet(request,response);
	}
}
