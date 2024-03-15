package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao;
import model.Dto;

@WebServlet("/MemberList.do")
public class MemberListController extends HttpServlet {
	
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
		ArrayList<Dto> posts = dao.list();
		request.setAttribute("list", posts);
		RequestDispatcher x = request.getRequestDispatcher("MemberList.jsp");
		x.forward(request, response);
	}

}
