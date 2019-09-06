package com.vote.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.ResponseData;
import domain.UserDAO;
import domain.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new UserDAO();
		
		String doing = request.getParameter("doing");
		
		if("join".equals(doing)) {
			Integer code = dao.insertUser(request.getParameter("id"), request.getParameter("password"),request.getParameter("name"),request.getParameter("email"));
			
			PrintWriter out = response.getWriter();
			out.print(code);
		}
	}
	
}
