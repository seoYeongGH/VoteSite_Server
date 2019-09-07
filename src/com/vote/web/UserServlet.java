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

import static com.vote.web.Constant.DUP_ID;
import static com.vote.web.Constant.SUCCESS;

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
		PrintWriter out = response.getWriter();
		
		String doing = request.getParameter("doing");
		System.out.println(doing);
		if("chkId".equals(doing)) {
			System.out.println("CHkID");
			if(dao.chkIdDup(request.getParameter("id")))
				out.print(DUP_ID);
			else
				out.print(SUCCESS);
		}
		else if("join".equals(doing)) {
			Integer code = dao.insertUser(request.getParameter("id"), request.getParameter("password"),request.getParameter("name"),request.getParameter("email"));
			out.print(code);
		}
	}
	
}
