package com.peisia.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.db.Dao;
import com.peisia.db.Dto;
import com.peisia.db.BoardListProcessor;

@WebServlet("/peisia/*") // 애노테이션 매핑
public class MainController extends HttpServlet {
	Dao dao;
	String nextPage;
	BoardListProcessor blp;
	@Override // 메인 서블렛으로 최초 진입할때 init이 처음 접속시 한번 초기화해줌
	public void init() throws ServletException {
		dao = new Dao();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo();
		System.out.println("action:"+action);
		if(action!=null) {
			switch (action){
			case "/list":
		    	nextPage = "/list.jsp";
		    	BoardListProcessor blp = dao.list(request.getParameter("page"),request.getParameter("word"));   
		    	request.setAttribute("blp",blp);
		    break;
			case "/write":
				nextPage="/peisia/list";
				Dto dto = new Dto(
						request.getParameter("title"),
						request.getParameter("text"),
						request.getParameter("id")
						);
				dao.write(dto);
				break;
			case "/read":
				nextPage="/read.jsp";
				Dto d=dao.read(request.getParameter("no"));
				request.setAttribute("post", d);
				break;
			case "/del":
				nextPage="/peisia/list";
				dao.del(request.getParameter("no"));
				break;
			case "/edit":
				nextPage="/edit.jsp";
				request.setAttribute("post", dao.read(request.getParameter("no")));
				break;
			case "/edit_proc":
				nextPage="/peisia/list";
				dao.edit(
						new Dto
						(
						request.getParameter("title"),
						request.getParameter("text")
						),
						request.getParameter("no")
						);
				break;
			case "/dellist":
				nextPage="/dellist.jsp"; //todo
				dao.dellist();
				break;
			case "/delread":
				nextPage="/delread.jsp"; //todo
				Dto d1= dao.delread(request.getParameter("no"));
				request.setAttribute("post", d1);
				break;
			case "/restore":
				nextPage="/peisia/dellist";
				dao.restore(request.getParameter("no"));
				break;
//			case "/proc_login":
//				nextPage="/peisia/list";
//				
		}
		RequestDispatcher d = request.getRequestDispatcher(nextPage);
		d.forward(request,response);
		}
	}
}
